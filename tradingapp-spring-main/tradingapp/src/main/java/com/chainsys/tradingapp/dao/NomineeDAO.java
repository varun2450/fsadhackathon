package com.chainsys.tradingapp.dao;

import com.chainsys.tradingapp.model.Nominee;
import java.sql.SQLException;
import java.util.List;

public interface NomineeDAO {
    void addNominee(Nominee nominee) throws SQLException, ClassNotFoundException;
    void updateNominee(Nominee nominee) throws SQLException, ClassNotFoundException;
    void deleteNominee(int nomineeId) throws SQLException, ClassNotFoundException;
    List<Nominee> getAllNomineesByUserId(int userId) throws SQLException, ClassNotFoundException;
    
    // New method
    Nominee getNomineeById(int id) throws SQLException, ClassNotFoundException;
}
