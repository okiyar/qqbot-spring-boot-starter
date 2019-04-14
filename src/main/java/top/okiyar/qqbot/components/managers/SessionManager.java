package top.okiyar.qqbot.components.managers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private static SessionManager instance;
//    private Sender sender = new Sender();

//    public Sender getSender() {
//        return sender;
//    }
//
//    public void setSender(Sender sender) {
//        this.sender = sender;
//    }

//    public static SessionManager getSessionManager() {
//        if (instance == null) {
//            return createInstance();
//        } else {
//            return instance;
//        }
//    }
//
//    private static synchronized SessionManager createInstance() {
//        if (instance == null) {
//            instance = new SessionManager();
//        }
//        return instance;
//    }

    private SessionManager() {
    }

    /**
     * 保存验证后的CQHttp反向Websocket链接的Api和Event的Session
     * <p>
     * Key: QQ号
     * Value: Api Session Id
     */
    private Map<String, String> serverApiSessionMap = new ConcurrentHashMap<>();

    /**
     * 保存已链接但未验证的Websocket Session
     */
    private Map<String, Session> allServerSessionMap = new ConcurrentHashMap<>();

    public void addSession(Session session) {
        try {
            requestValideSessionInfo(session);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Session getSession(String selfId) {
        return allServerSessionMap.get(serverApiSessionMap.get(selfId));
    }

    /**
     * 请求验证信息
     */
    private void requestValideSessionInfo(Session session) throws IOException {

        String rawPath = session.getRequestURI().getRawPath();

        // 过滤Event
        if (rawPath.indexOf("api") != -1) {
            allServerSessionMap.put(session.getId(), session);
            session.getBasicRemote().sendText("{\"action\":\"get_login_info\"}");
        } else if (rawPath.indexOf("event") != -1) {
            allServerSessionMap.put(session.getId(), session);
        } else {
            // 不合法映射地址
            session.close();
        }
    }

    /**
     * 处理验证信息
     */
    private void handleValideSessionInfo(String message, Session session) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(message);
            jsonNode = jsonNode.get("data").get("user_id");
            serverApiSessionMap.put(jsonNode.toString(), session.getId());
            System.out.println("验证成功！ QQ:" + jsonNode.toString() + " Websocket Session Id:" + session.getId());
        } catch (Exception e) {
            allServerSessionMap.remove(session.getId());
            session.close();
            System.out.println("验证失败!");
        }
    }

    public void distribute(Session session, String message) {
        if (session.getRequestURI().getRawPath().indexOf("api") != -1 && !serverApiSessionMap.containsValue(session.getId())) {
            System.out.println("进入验证：" + session.getId() + " " + message);
            try {
                handleValideSessionInfo(message, session);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
//            EventManager.getEventManager().dealPost(message);
        }
    }

    /**
     * 移除断开连接的Websocket Session
     *
     * @param sessionId 带删除的Session Id
     */
    public void removeSession(String sessionId) {
        if (serverApiSessionMap.containsValue(sessionId)) {
            serverApiSessionMap.forEach((key, value) -> {
                if (sessionId.equals(value)) {
                    serverApiSessionMap.remove(key);
                    System.out.println("移除api session :" + sessionId);
                }
            });
        }

        if (allServerSessionMap.containsKey(sessionId)) {
            allServerSessionMap.remove(sessionId);
            System.out.println("移除event session :" + sessionId);
        }

        System.out.println("当前 Session 数量:" + allServerSessionMap.size());
    }
}
