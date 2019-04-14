package top.okiyar.qqbot.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import top.okiyar.qqbot.base.CQHttpBase;

import java.util.Map;

public class HttpClient {
    public static void main(String[] args) throws InterruptedException, JsonProcessingException {
        CQHttpBase qqApi = new CQHttpBase();
        for (int i = 1; i <= 1; i++) {
            System.out.println("第" + i + "次请求");
            RestTemplate rt = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

            Map map = qqApi.sendPrivateMsg(384758755, "年红红", null);

            map = qqApi.getCookies(null);

            map = qqApi.getCredentials(null);

            map = qqApi.getGroupList(null);

            map = qqApi.getStrangerInfo(55555, null);

            map = qqApi.getVersionInfo(null);

            map = qqApi._getFriendList(null);

            map = qqApi.getVersionInfo(null);

            String uri = "http://localhost:5700/" + map.get("action");
            String params = new ObjectMapper().writeValueAsString(map.get("params"));


            HttpEntity<String> entity = new HttpEntity<String>(params, headers);
            try {
                String strbody = rt.exchange(uri, HttpMethod.GET, entity, String.class).getBody();
                System.out.println(strbody);
            } catch (Exception e) {
            }

            Thread.sleep(100);
        }
    }
}
