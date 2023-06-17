package com.example.curdblog.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class UpdateDaoImpl implements UpdateDao {
    @Autowired
    private DataSource dataSource;

    @Override
    public String update(int id, JSONObject data) {
        System.out.println("6666666666"+data);
        JSONObject jsonObject = JSONObject.parseObject(data.toString());
        System.out.println(jsonObject);
        String text = jsonObject.getString("data");
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE DATA SET data=? WHERE id=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, text);
                stmt.setInt(2, id);
                int rows = stmt.executeUpdate();
                return "Updated " + rows + " rows";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Update failed: " + ex.getMessage();
        }
    }
}
