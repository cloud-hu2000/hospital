package com.example.hospital.controller;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CloudHu
 * @date 2022年12月31日 12:23
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/map")
    public String map(){

        return "";
    }
}
