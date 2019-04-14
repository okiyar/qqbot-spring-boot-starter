package top.okiyar.qqbot.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
    请求参数说明:
    参数说明

    参数	        类型	 是否必须	取值范围	说明
    reqType	    int 	N	        -	输入类型:0-文本(默认)、1-图片、2-音频
    perception	-	    Y	        -	输入信息
    userInfo	-	    Y	        -	用户参数

    perception
    参数	        类型	是否必须	取值范围	说明
    inputText	-	    N	    -	文本信息
    inputImage	-	    N	    -	图片信息
    inputMedia	-	    N	    -	音频信息
    selfInfo	-	    N	    -	客户端属性
    注意：输入参数必须包含inputText或inputImage或inputMedia！

    inputText
    参数	        类型	    是否必须	取值范围	    说明
    text	    String	    Y	1-128字符	直接输入文本

    inputImage
    参数	        类型	    是否必须	取值范围	说明
    url	        String	    Y	    	图片地址

    inputMedia
    参数	        类型	    是否必须	取值范围	说明
    url	        String	    Y   		音频地址

    selfInfo
    参数	        类型	是否必须	取值范围	说明
    location	-	    N	    -	地理位置信息

    location
    参数	        类型	    是否必须	取值范围	说明
    city	    String	    Y	    -	所在城市
    province	String	    N	    -	省份
    street	    String	    N	    -	街道

    userInfo
    参数	        类型	    是否必须	取值范围	        说明
    apiKey	    String	    Y	32位	            机器人标识
    userId	    String	    Y	长度小于等于32位	用户唯一标识
    groupId	    String	    N	长度小于等于64位	群聊唯一标识
    userIdName	String  	N	长度小于等于64位	群内用户昵称
    ==========================================================
    返回参数说明：
    参数	    类型	是否必须	取值范围	说明
    intent	-	    Y	    -	请求意图
    results	-	    N	    -	输出结果集

    intent
    参数	        类型	    是否包含	取值范围	说明
    code	    int	        Y	    -	输出功能code
    intentName	String	    N	    -	意图名称
    actionName	String	    N	    -	意图动作名称
    parameters	Map	        N	    -	功能相关参数

    results
    参数	        类型	    是否包含	取值范围	                                                            说明
    resultType	String	    Y	文本(text);连接(url);音频(voice);视频(video);图片(image);图文(news)	输出类型
    values	    -	        Y	-	                                                                输出值
    groupType	int	        Y	-	                ‘组’编号:0为独立输出，大于0时可能包含同组相关内容 (如：音频与文本为一组时说明内容一致)

    ==========================================================
    异常码说明：
    异常码	说明
    5000	无解析结果
    6000	暂不支持该功能
    4000	请求参数格式错误
    4001	加密方式错误
    4002	无功能权限
    4003	该apikey没有可用请求次数
    4005	无功能权限
    4007	apikey不合法
    4100	userid获取失败
    4200	上传格式错误
    4300	批量操作超过限制
    4400	没有上传合法userid
    4500	userid申请个数超过限制
    4600	输入内容为空
    4602	输入文本内容超长(上限150)
    7002	上传信息失败
    8008	服务器错误
    0	    上传成功
 */
public class TuringBot {
    private String SERVER_URL = "http://openapi.tuling123.com/openapi/api/v2";
    private Map<Integer, String> apiKey = new ConcurrentHashMap<>();
    private static TuringBot instance;
    private int currApiPosition = 0;
    private int timesLimitCounter = 0;

    private TuringBot() {
    }

    public static TuringBot getInstance() {
        if (instance == null) {
            createInstance();

            // 设置自己的 apiKey
            instance.addApiKey("ea606ef785354db6a3bd949b322e9286",
                    "d12beafd42bf42009bea5f5677c35624",
                    "0ae12eb983104f7fbea09d667dff6cb4",
                    "01c73ec258c34100b5c1836d733ce07f",
                    "4bf6f43bde52493d935e9196219808e9",
                    "9f9d4b0f690c44b6a1b3478f7dc647fd",
                    "30fd2f425b4e47339fae3bd5d2734734",
                    "eb80d301cb5d4590941d49e1a547a006",
                    "885f939f7f1849c887e09c3faf1d5ca6",
                    "bfd2c609e2134fbabe56d2556cb17d29");
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new TuringBot();
        }
    }

    public void addApiKey(String... apiKey) {
        for (int i = 0; i < apiKey.length; i++) {
            this.apiKey.put(this.apiKey.size(), apiKey[i]);
        }
    }

    public void addApiKey(List<String> apiKey) {
        apiKey.forEach(k -> {
            addApiKey(k);
        });
    }

    public int getApiKeySize() {
        return apiKey.size();
    }

    public String getText(String reqText) {
        return getUserIdText(reqText, "" + new Date().getTime());
    }

    public String getUserIdText(String reqText, String userId) {
        return request(reqText, userId, null, null);
    }

    private String request(String reqText, String userId, String groupId, String groupMemberName) {
        if (reqText.indexOf("[CQ:") != -1) {
            System.out.println("图灵机器人不处理非文字内容！");
            reqText = "何明光";
        }
        JsonObject jo = new JsonObject();
        JsonObject jo1 = new JsonObject();
        jo1.addProperty("inputText", "{\"text\":\"" + reqText + "\"}");
        jo.add("perception", jo1);
        JsonObject jo2 = new JsonObject();
        jo2.addProperty("apiKey", apiKey.get(this.currApiPosition));
        if (userId != null) {
            jo2.addProperty("userId", userId);
        } else if (groupMemberName != null) {
            jo2.addProperty("groupId", groupId);
            jo2.addProperty("userIdName", groupMemberName);
        } else {
            jo2.addProperty("groupId", groupId);
        }
        jo.add("userInfo", jo2);
        try {
            URL url = new URL(SERVER_URL);
            HttpURLConnection httpClient = (HttpURLConnection) url.openConnection();
            httpClient.setDoInput(true);
            httpClient.setDoOutput(true);
            httpClient.setRequestMethod("POST");
            httpClient.setUseCaches(false);
            httpClient.setInstanceFollowRedirects(true);
            httpClient.setRequestProperty("Content-Type", "application/json");
            httpClient.connect();

            try (OutputStream os = httpClient.getOutputStream()) {
                os.write(jo.toString().getBytes("UTF-8"));
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(httpClient.getInputStream()))) {
                String lines;
                StringBuffer sbf = new StringBuffer();
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), "utf-8");
                    sbf.append(lines);
                }
                System.out.println(sbf.toString());
                jo = (JsonObject) new JsonParser().parse(sbf.toString());
                if (jo.get("intent").getAsJsonObject().get("code").getAsInt() != 4003) {
                    JsonArray ja = jo.get("results").getAsJsonArray();
                    if (ja.size() == 1) {
                        return ja.get(0).getAsJsonObject().get("values").getAsJsonObject().get("text").getAsString();
                    }
                } else {
                    currApiPosition = ++currApiPosition % apiKey.size();
                    timesLimitCounter++;
                    System.out.println(timesLimitCounter);
                    if (timesLimitCounter > apiKey.size()) {
                        timesLimitCounter = 0;
                        return "所有API请求次数已用完!";
                    }
                    return request(reqText, userId, groupId, groupMemberName);
                }
            }
            httpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return jo.toString();
    }
}
