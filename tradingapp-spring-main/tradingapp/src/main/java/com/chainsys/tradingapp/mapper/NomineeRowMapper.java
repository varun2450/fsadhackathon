package com.chainsys.tradingapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.tradingapp.model.Nominee;

public class NomineeRowMapper implements RowMapper<Nominee> {
    @Override
    public Nominee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Nominee nominee = new Nominee();
        nominee.setId(rs.getInt("id"));  // Ensure 'id' column exists in database
        nominee.setUserId(rs.getInt("user_id"));  // Ensure 'user_id' column exists in database
        nominee.setName(rs.getString("name"));  // Ensure 'name' column exists in database
        nominee.setRelationship(rs.getString("relationship"));  // Ensure 'relationship' column exists in database
        return nominee;
    }
}
