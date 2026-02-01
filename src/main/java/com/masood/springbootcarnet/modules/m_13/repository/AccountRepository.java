package com.masood.springbootcarnet.modules.m_13.repository;

import com.masood.springbootcarnet.modules.m_13.AccountMapper;
import com.masood.springbootcarnet.modules.m_13.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

//@Repository
public class AccountRepository {

    private final JdbcTemplate mJdbcTemplate;

    //@Autowired
    public AccountRepository(JdbcTemplate _jdbcTemplate) {
        this.mJdbcTemplate = _jdbcTemplate;
    }


    public Account findAccountById(long _id) {

        String sql = "SELECT * FROM ACCOUNT WHERE ID = ?";
        return mJdbcTemplate.queryForObject(sql,new AccountMapper(), _id);

    }

    public void changeAmount(long _id, BigDecimal _amount) {

        String sql = "UPDATE ACCOUNT SET AMOUNT = ? WHERE ID = ?";
        mJdbcTemplate.update(sql,_amount,_id);

    }

    public List<Account> getAllAccounts() {

        String sql = "SELECT * FROM ACCOUNT";
        return mJdbcTemplate.query(sql,new AccountMapper());

    }


}
