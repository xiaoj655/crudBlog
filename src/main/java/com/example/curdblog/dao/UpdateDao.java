package com.example.curdblog.dao;

import com.alibaba.fastjson.JSONObject;

public interface UpdateDao {
    String update(int id, JSONObject data);
}
