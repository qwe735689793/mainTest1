package com.mhj.demo.controller;

import com.alibaba.fastjson.JSON;
import com.mhj.demo.config.JmsConfig;
import com.mhj.demo.config.rocketMQ.Producer;
import com.mhj.demo.entity.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/12/4 14:24
 **/
@Slf4j
@RestController
public class rocketMQTest {
    @Autowired
    private Producer producer;

    private List<String> mesList;

    /**
     * 初始化消息
     */
    public rocketMQTest() {
        mesList = new ArrayList<>();
        mesList.add("小小");
        mesList.add("爸爸");
        mesList.add("妈妈");
        mesList.add("爷爷");
        mesList.add("奶奶");
    }

    @RequestMapping("/text/rocketmq")
    public Object callback() throws Exception {
        //总共发送五次消息
        for (String s : mesList) {
            //创建生产信息
            Message message = new Message(JmsConfig.TOPIC, "testtag", ("小小一家人的称谓:" + s).getBytes());
            //发送
            SendResult sendResult = producer.getProducer().send(message);
            log.info("输出生产者信息={}",sendResult);
        }
        return "成功";
    }
    //下单
    @RequestMapping("/order/prod/{pid}")
    public User order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);

        //模拟调用商品微服务需要2s的时间
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user =new User();
        user.setName("用户1");
        user.setAge(18);

        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(user));

        //下单(创建订单)

        //为了不产生大量的额垃圾数据,暂时不保存订单入库
        //orderService.createOrder(order);

        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(user));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }

    //测试高并发
    @RequestMapping("/order/message")
    public String message() {
        return "测试高98并819发";
    }
}
