package com.mhj.order.modules.controller;

import com.alibaba.fastjson.JSON;
import com.mhj.order.modules.entity.Order;
import com.mhj.order.modules.service.MainApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2021/4/15 10:08
 **/
@RestController
@Slf4j
public class orderController {
    @Autowired
    private MainApi mainApi;

    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
        //调用商品微服务,查询商品信息
        // Product product = productService.findByPid(pid);
        String str = mainApi.getOrderNo();
        log.info("查询到{}号商品的信息,内容是:{}", str, JSON.toJSONString("1"));
        //模拟一次网络延时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//下单(创建订单)
        Order order = new Order();
        order.setUid("222");
        order.setUserName("测试用户");
        order.setPName("商品1");
        order.setPPrice(16);
//为了不产生太多垃圾数据,暂时不做订单保存
//orderService.createOrder(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        return order;
    }

    @RequestMapping("/order/message")
    public String message() {
        return "高并发下的问题测试";
    }
}
