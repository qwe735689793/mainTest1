package com.mhj.sms.Async;

import com.mhj.sms.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2021/5/13 15:19
 **/
@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @PostMapping("/test/post")
    public String postTest(@RequestBody User user, @RequestParam String id){
        return "2";
    }

    @GetMapping("/open/something")
    public String something() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            log.info("返回值:{}",asyncService.doSomething("index = " + i));
            ;
        }
        return "success";
    }
}


