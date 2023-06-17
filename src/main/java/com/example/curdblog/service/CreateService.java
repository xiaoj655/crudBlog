package com.example.curdblog.service;

import com.alibaba.fastjson.JSONObject;
import com.example.curdblog.dao.CreateDao;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateService {
    @Autowired
    CreateDao createDao;
    public String create(String postJson) {
        JSONObject jsonObject = JSONObject.parseObject(postJson);
        String data = jsonObject.getString("data");
        try {
            createDao.insert(data);
        } catch (Exception e) {
            return "添加失败" + e.getStackTrace();
        }
        return "添加成功";
    }
}
