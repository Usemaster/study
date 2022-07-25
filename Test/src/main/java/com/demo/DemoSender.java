package com.demo;

import com.xiaomi.xmpush.server.*;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;


/**
 * @author gongwj
 * @Date 2022/7/20
 */
public class DemoSender {

    private static final String APP_SECRET_KEY = "B4/JJGy0KXQjHMymKGmqmA==";
    private static final String MY_PACKAGE_NAME = "com.yy.basedemo";
    private static final String regId = "9JbuPMllDSjzl1UtnukaNFO4DzHfaVBYgS5KVjvHrhd91TmGZO2nfBUMd1z5KvpD";

    public static void main(String[] args) throws Exception{
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a pasThrough message";
        String title = "pasThrough notification title";
        String description = "pasThrough notification description";
        //alias非空白, 不能包含逗号, 长度小于128
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                //设置透传类型 0是通知消息 1是透传消息
                .passThrough(1)
                // 使用默认提示音提示
                .notifyType(1)
                .build();
        //根据alias, 发送消息到指定设备上
        sender.send(message, regId, 3);
    }

    /**
     * 发送透传消息
     */
    @Test
    public void sendPassThrough() throws Exception{
        //正式环境下使用Push服务，启动时需要调用如下代码
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a pasThrough message";
        String title = "pasThrough notification title";
        String description = "pasThrough notification description";
        //alias非空白, 不能包含逗号, 长度小于128
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                //设置透传类型 0是通知消息 1是透传消息
                .passThrough(1)
                // 使用默认提示音提示
                .notifyType(1)
                .build();
        //根据alias, 发送消息到指定设备上
        sender.send(message, regId, 3);
    }


    /**
     * 通过标签推送
     */
    @Test
    public void sendBroadcast() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a topic message";
        String title = "topic notification title";
        String description = "topic notification description";
        String topic = "testTopic";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .passThrough(1)
                .notifyType(1)     // 使用默认提示音提示
                .build();
        sender.broadcast(message, topic, 3); //根据topic, 发送消息到指定一组设备上
    }


    /**
     * 通过regId发送消息
     */
    @Test
    public void sendMessage() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a regid message";
        String title = "regid notification title";
        String description = "regid notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                // 使用默认提示音提示
                .extra("channel_id","test")
                .notifyType(1)
                .build();
        Result result = sender.send(message, regId, 3);
    }

    /**
     * 通过别名发送消息
     */
    @Test
    public void sendMessageToAlias() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        //alias非空白, 不能包含逗号, 长度小于128
        String alias = "testAlias";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                // 使用默认提示音提示
                .notifyType(1)
                .build();
        //根据alias, 发送消息到指定设备上
        sender.sendToAlias(message, alias, 3);
    }

    @Test
    /**
     * 通过userAccount设置
     */
    public void sendMessageToUserAccount() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        //userAccount非空白, 不能包含逗号, 长度小于128
        String userAccount = "testUserAccount";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .notifyType(1)     // 使用默认提示音提示
                .build();
        sender.sendToUserAccount(message, userAccount, 3); //根据useraccount, 发送消息到指定设备上
    }


}
