package com.example.curdblog.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.curdblog.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UpdateController {
    @Autowired
    private UpdateService updateService;

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestBody JSONObject data) {
        String result = null;
        result = updateService.update(id, data);
        return result;
    }
}
