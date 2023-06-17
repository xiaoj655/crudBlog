package com.example.curdblog.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.curdblog.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class UpdateController {
//    @Autowired
//    UpdateService updateService;
//
//    @RequestMapping("/update")
//    public String update(@RequestBody String data, Integer id) {
//        String result = null;
//        result = updateService.update(id, data);
//        return result;
//    }
//}
@RestController
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
