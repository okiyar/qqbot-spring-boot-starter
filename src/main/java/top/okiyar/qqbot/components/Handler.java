package top.okiyar.qqbot.components;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import top.okiyar.qqbot.bean.base.Info;
import top.okiyar.qqbot.utils.Json;
import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.event.*;
import top.okiyar.qqbot.exceptions.QQBotParseCQHttpJsonMsgException;

import java.io.IOException;
import java.util.Map;

public class Handler {

    public static void main(String[] args) throws IOException {
        String s = null;
        switch (s) {
            case "2":
                break;
        }
    }

    public Event parseMessageTypeJson(Map map) throws JsonProcessingException {
        String msgType = (String) map.get("message_type");
        if (msgType != null) {
            if ("private".equals(msgType)) {
                // 好友消息
                return new PrivateMessageEvent(Json.PrivateMessage(new ObjectMapper().writeValueAsString(map)));
            } else if ("group".equals(msgType)) {
                // 群消息
                return new GroupMessageEvent(Json.GroupMessage(new ObjectMapper().writeValueAsString(map)));
            }
        }

        return null;
    }


    public Event parseRequestTypeJson(Map map) throws JsonProcessingException {
        String requestType = (String) map.get("request_type");
        if (requestType != null) {
            if ("friend".equals(requestType)) {
                // 添加好友
                return new FriendAddEvent(Json.FriendAddMessage(new ObjectMapper().writeValueAsString(map)));
            } else if ("group".equals(requestType)) {
                // 群添加
                return new GroupJoinEvent(Json.GroupJoinMessage(new ObjectMapper().writeValueAsString(map)));
            }
        }
        return null;
    }

    public Event parseNoticeTypeJson(Map map) throws JsonProcessingException {
        String noticeType = (String) map.get("notice_type");
        if (noticeType != null) {
            switch (noticeType) {
                // 群文件上传消息
                case "group_upload":
                    return null;

                case "group_admin": {
                    // 任命群管理员消息
                    if ("set".equals(map.get("sub_type"))) {
                        return new GroupAdminSetEvent(Json.GroupNotifyMessage(new ObjectMapper().writeValueAsString(map)));
                        // 取消群管理员消息
                    } else if ("unset".equals(map.get("sub_type"))) {
                        return new GroupAdminUnsetEvent(Json.GroupNotifyMessage(new ObjectMapper().writeValueAsString(map)));
                    }
                }
                // 群成员减少
                case "group_decrease":
                    return new GroupMemberDecreaseEvent(Json.GroupNotifyMessage(new ObjectMapper().writeValueAsString(map)));
                // 群成员增加
                case "group_increase":
                    return new GroupMemberIncreaseEvent(Json.GroupNotifyMessage(new ObjectMapper().writeValueAsString(map)));
            }
        }
        return null;
    }

    public Object parseJsonMsg(String jsonMsg) throws QQBotParseCQHttpJsonMsgException, IOException {
        // 解析json
        // 若上报事件则分类事件并和相应消息封装后加入事件队列
        // 若发送结果反馈则触发结果回调函数

        /*
            解析思路：第一步：判断 retcode，若存在所列值则进入相应子判断是否含有 data 数据判断是否是数据查询。否则进入第二步
                     第二步：判断 post_type:message|request|notice|other
                           1.判断 message_type:private|group
                           2.判断 notice_type:group_upload|group_admin|group_decrease|group_increase
                           3.判断 sub_type:set|unset
         */
        Event event = null;
        JsonObject json = (JsonObject) new JsonParser().parse(jsonMsg);

        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(jsonMsg, Map.class);

        // 判断是否为发送结果反馈消息
        JsonElement je = json.get("retcode");
        if (map.containsKey("retcode")) {

            String data = (String) map.get("data");
            if (data == null) {
                // 调用结果返回
                return new Gson().fromJson(json, Info.class);
            } else {

            }

            System.out.println("反馈消息：" + jsonMsg);
            // 触发结果回调
//            ResultInfo resultInfo = new ResultInfo(json.toString());
        } else {
            // 判断是否为 message|request|notice 消息
            String postType = (String) map.get("post_type");
            if (map.containsKey("post_type")) {
                switch (postType) {
                    // 内容消息
                    case "message": {
                        return parseMessageTypeJson(map);
                    }
                    // 请求消息
                    case "request": {
                        return parseRequestTypeJson(map);
                    }
                    // 通知消息
                    case "notice": {
                        return parseNoticeTypeJson(map);
                    }
                }
            }
        }
        return event;
    }
}
