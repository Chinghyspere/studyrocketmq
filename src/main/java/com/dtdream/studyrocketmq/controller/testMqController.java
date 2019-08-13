package com.dtdream.studyrocketmq.controller;

/*
 *
 *     @author Qmh
 *     @Date 2019/8/13 15:20
 *
 *
 */


import com.alibaba.fastjson.JSONObject;
import com.dtdream.studyrocketmq.producer.mqProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rocketMq")
@RestController
public class testMqController {

    @Autowired
    private mqProducer mqProducer;


    @RequestMapping("/api/v1/test")
    public void callback(String text) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        // 创建消息  主题   二级分类   消息内容好的字节数组
        Message message = new Message("mq_test_topic", "taga", ("hello rocketMQ " + text).getBytes());
        SendResult send = mqProducer.getProducer().send(message);

        System.out.println(send);

    }

}
