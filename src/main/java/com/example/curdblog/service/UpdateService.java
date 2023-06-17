package com.example.curdblog.service;

import com.alibaba.fastjson.JSONObject;
import com.example.curdblog.dao.UpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
    @Autowired
    UpdateDao updateDao;

    public String update(int id, JSONObject data) {
        String result = null;
        result = updateDao.update(id,data);
        return result;
    }
}
