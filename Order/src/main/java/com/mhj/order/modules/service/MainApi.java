package com.mhj.order.modules.service;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2021/1/6 9:52
 **/

import feign.QueryMap;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "spring-cloud-alibaba-study")
public interface MainApi {

    /**
     *  feign调用测试
     * @return
     */
    @GetMapping("/test1")
    String getOrderNo();

}