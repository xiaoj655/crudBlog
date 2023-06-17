package com.example.curdblog.controller;

import com.example.curdblog.service.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateController {
    @Autowired
    CreateService createService;

    @RequestMapping("create")
    public String create(@RequestBody String postJson) {
        String result = null;
        result = createService.create(postJson);
        return result;
    }
}
