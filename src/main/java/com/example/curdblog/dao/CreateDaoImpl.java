package com.example.curdblog.dao;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class CreateDaoImpl implements CreateDao {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "brook";
    private static final String PASSWORD = "1";

    @Override
    public void insert(String data) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO DATA (data) VALUES (?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, data);
                int rows = stmt.executeUpdate();
                System.out.println(rows + " rows inserted.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
