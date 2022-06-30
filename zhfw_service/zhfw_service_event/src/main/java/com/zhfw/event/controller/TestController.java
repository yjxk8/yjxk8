package com.zhfw.event.controller;

import org.springframework.web.bind.annotation.*;

/**
 * ClassName: TestController
 * Author: Admin
 * Date: 2022/4/30 22:44
 *
 * @description: TODO
 */


@RestController
@CrossOrigin("*")
@RequestMapping("/test")

public class TestController {

    @GetMapping
    public String test(@RequestParam String key){
        return key;
    }

}
