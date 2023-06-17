package com.example.curdblog.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@Component
//public class RetrieveDaoImpl implements RetrieveDao {
//
//    @Override
//    public JSONObject retrieve() {
//        JSONObject result = new JSONObject();
//        return result;
//    }
//}

@Component
public class RetrieveDaoImpl implements RetrieveDao {
    @Autowired
    private DataSource dataSource;

    @Override
    public JSONObject retrieve() {
        JSONObject result = new JSONObject();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM DATA";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
//                        String name = rs.getString("data");
                        String data = rs.getString("data");
                        // 将其他列的值赋给相应的变量
                        // 在这里将每一行的信息存储到 JSONObject 对象中
                        JSONObject row = new JSONObject();
                        row.put("id", id);
                        row.put("data", data);
                        // 将其他列的值存储到相应的键中
                        // 然后将 row 对象添加到 result 对象中
                        result.put(String.valueOf(id), row);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
