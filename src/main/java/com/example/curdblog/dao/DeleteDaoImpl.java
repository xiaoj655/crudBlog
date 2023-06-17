package com.example.curdblog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class DeleteDaoImpl implements DeleteDao {
    @Autowired
    private DataSource dataSource;

    @Override
    public String delete(int id) {
        System.out.println("this is the id: "+id);
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DELETE FROM DATA WHERE id=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int rows = stmt.executeUpdate();
                return "Deleted " + rows + " rows";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Delete failed: " + ex.getMessage();
        }
    }
}
