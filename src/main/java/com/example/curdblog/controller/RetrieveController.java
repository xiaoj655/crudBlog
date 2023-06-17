package com.example.curdblog.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.curdblog.dao.RetrieveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetrieveController {
    @Autowired
    RetrieveDao retrieveDao;
    @GetMapping("/retrieve")
    public JSONObject retrieve() {
        JSONObject result = null;
        result = retrieveDao.retrieve();
        return result;
    }
}
