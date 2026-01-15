package com.jdbcconnectivity.bankmanagement.dao.impl;

import com.jdbcconnectivity.bankmanagement.dao.LoginDAO;
import com.jdbcconnectivity.bankmanagement.model.Login;
import com.jdbcconnectivity.bankmanagement.util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public void addLogin(Login login) {
        String sql = "INSERT INTO login (login_id, role, password) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, login.getLoginId());
            stmt.setString(2, login.getRole());
            stmt.setString(3, login.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Login getLoginById(int loginId) {
        String sql = "SELECT * FROM login WHERE login_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loginId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Login(rs.getInt("login_id"), rs.getString("role"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Login> getAllLogins() {
        List<Login> logins = new ArrayList<>();
        String sql = "SELECT * FROM login";
        try (Connection conn = DatabaseUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                logins.add(new Login(rs.getInt("login_id"), rs.getString("role"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logins;
    }

    @Override
    public void updateLogin(Login login) {
        String sql = "UPDATE login SET role = ?, password = ? WHERE login_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login.getRole());
            stmt.setString(2, login.getPassword());
            stmt.setInt(3, login.getLoginId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLogin(int loginId) {
        String sql = "DELETE FROM login WHERE login_id = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loginId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Login authenticate(int loginId, String password) {
        String sql = "SELECT * FROM login WHERE login_id = ? AND password = ?";
        try (Connection conn = DatabaseUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loginId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Login(rs.getInt("login_id"), rs.getString("role"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
