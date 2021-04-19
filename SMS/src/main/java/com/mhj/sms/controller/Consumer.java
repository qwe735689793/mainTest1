package com.mhj.sms.controller;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2021/4/9 14:16
 **/
@Component
@RocketMQMessageListener(topic ="topic_family",consumerGroup = "test_consumer")
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("消费到的数据为："+s);
    }
}
