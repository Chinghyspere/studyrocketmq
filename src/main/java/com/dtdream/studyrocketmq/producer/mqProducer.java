package com.dtdream.studyrocketmq.producer;

/*
 *
 *     @author Qmh
 *     @Date 2019/8/13 10:06
 *
 *
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Slf4j
public class mqProducer {

    /**
     * 生产组,生产者必须在生产组内
     */
    private String producerGroup = "pay_group";
    /**
     * 端口
     */
    private String nameServer = "127.0.0.1:9876";


    private DefaultMQProducer producer;


    @PostConstruct
    public void init() {
        log.info("RocketMq is init()!");
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr("127.0.0.1:9876");
        start();
        log.info("RocketMq is init()! has finished");
    }


//    @PreDestroy
//    public  void end(){
//        log.info("RocketMq is init() finished!");
//    }

    public mqProducer() {
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }

    /**
     * 对象在使用之前必须调用一次,并且只能初始化一次
     */
    public void start() {
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一般在应用上下文,使用上下文监听器,进行关闭
     */


}

