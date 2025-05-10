package com.chainsys.tradingapp.dao.impl;

import com.chainsys.tradingapp.dao.NomineeDAO;
import com.chainsys.tradingapp.model.Nominee;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NomineeImpl implements NomineeDAO {

    @Override
    public void addNominee(Nominee nominee) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "INSERT INTO nominees (user_id, name, relationship) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, nominee.getUserId());
        ps.setString(2, nominee.getName());
        ps.setString(3, nominee.getRelationship());
        ps.executeUpdate();
        ps.close();
        connection.close();
    }

    @Override
    public void updateNominee(Nominee nominee) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "UPDATE nominees SET name = ?, relationship = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nominee.getName());
        ps.setString(2, nominee.getRelationship());
        ps.setInt(3, nominee.getId());
        ps.executeUpdate();
        ps.close();
        connection.close();
    }

    @Override
    public void deleteNominee(int nomineeId) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "DELETE FROM nominees WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, nomineeId);
        ps.executeUpdate();
        ps.close();
        connection.close();
    }

    @Override
    public List<Nominee> getAllNomineesByUserId(int userId) throws SQLException, ClassNotFoundException {
        List<Nominee> list = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT id, user_id, name, relationship FROM nominees WHERE user_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Nominee nominee = new Nominee();
            nominee.setId(rs.getInt("id"));
            nominee.setUserId(rs.getInt("user_id"));
            nominee.setName(rs.getString("name"));
            nominee.setRelationship(rs.getString("relationship"));
            list.add(nominee);
        }
        rs.close();
        ps.close();
        connection.close();
        return list;
    }

    @Override
    public Nominee getNomineeById(int id) throws SQLException, ClassNotFoundException {
        Nominee nominee = null;
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT id, user_id, name, relationship FROM nominees WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            nominee = new Nominee();
            nominee.setId(rs.getInt("id"));
            nominee.setUserId(rs.getInt("user_id"));
            nominee.setName(rs.getString("name"));
            nominee.setRelationship(rs.getString("relationship"));
        }
        rs.close();
        ps.close();
        connection.close();
        return nominee;
    }
}
