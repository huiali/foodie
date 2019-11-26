package com.huiali.controller;

import com.huiali.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/get")
    public Object get(int id) {
        return testService.get(id);
    }

    @GetMapping("/post")
    public Object post(int id) {
        return testService.get(id);
    }

    @GetMapping("/update")
    public Object update(int id) {
        testService.update(id);
        return "OK";
    }

    @GetMapping("/delete")
    public Object delete(int id) {
        testService.delete(id);
        return "OK";
    }

}
