package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.okiyar.qqbot.QQBot;
import top.okiyar.qqbot.bean.event.*;
import top.okiyar.qqbot.bean.listener.*;
import top.okiyar.qqbot.components.Bot;

@RestController
public class Controller {


    @Autowired
    QQBot qqBot;

    @RequestMapping("/bot")
    public String info() {
        return qqBot.getBotManager().getBotSize() + "";
    }

    @RequestMapping("/init")
    public String init() {
        qqBot.getListenerManager().addListener(new PrivateMessageEventListener() {
            @Override
            public void dealEvent(PrivateMessageEvent event, Bot bot) {
                System.out.println("好友消息：" + event.getMessage());
                bot.getQqApi().sendPrivateMsg(384758755, event.getMessage().getMessage() + " 收到收到");
            }
        }).addListener(new GroupMessageEventListener() {
            @Override
            public void dealEvent(GroupMessageEvent event, Bot bot) {
                System.out.println("群消息：" + event.getMessage());
                bot.getQqApi().sendPrivateMsg(384758755, "收到群消息");
            }
        }).addListener(new FriendAddEventListener() {
            @Override
            public void dealEvent(FriendAddEvent event, Bot bot) {
                System.out.println("添加好友消息：" + event.getMessage());
            }
        }).addListener(new GroupAdminSetEventListener() {
            @Override
            public void dealEvent(GroupAdminSetEvent event, Bot bot) {
                System.out.println("群管理员设置消息：" + event.getMessage());
            }
        }).addListener(new GroupAdminUnsetEventListener() {
            @Override
            public void dealEvent(GroupAdminUnsetEvent event, Bot bot) {
                System.out.println("群管理员取消设置消息：" + event.getMessage());
            }
        }).addListener(new GroupJoinEventListener() {
            @Override
            public void dealEvent(GroupJoinEvent event, Bot bot) {
                System.out.println("群添加消息:" + event.getMessage());
            }
        }).addListener(new GroupMemberDecreaseEventListener() {
            @Override
            public void dealEvent(GroupMemberDecreaseEvent event, Bot bot) {
                System.out.println("群成员减少消息:" + event.getMessage());
            }
        }).addListener(new GroupMemberIncreaseEventListener() {
            @Override
            public void dealEvent(GroupMemberIncreaseEvent event, Bot bot) {
                System.out.println("群成员增加消息：" + event.getMessage());
            }
        }).addListener(new GroupNotifyEventListener() {
            @Override
            public void dealEvent(GroupNotifyEvent event, Bot bot) {
                System.out.println("群通知消息：" + event.getMessage());
            }
        }).addListener(new BotOfflineEventListener() {
            @Override
            public void dealEvent(BotOfflineEvent event, Bot bot) {
                System.out.println("Bot " + bot.getBotId() + " 离线了");
            }
        }).addListener(new BotOnlineEventListener() {
            @Override
            public void dealEvent(BotOnlineEvent event, Bot bot) {
                System.out.println("Bot " + bot.getBotId() + " 上线了");
            }
        });
        return "ListenerInitFinished!";
    }
}
