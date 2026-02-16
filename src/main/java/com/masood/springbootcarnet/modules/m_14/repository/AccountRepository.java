package com.masood.springbootcarnet.modules.m_14.repository;

import com.masood.springbootcarnet.modules.m_14.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.math.BigDecimal;
import java.util.List;


/***
 * Simple JDBC Repository used by the Spring Data Project
 */
public interface AccountRepository extends CrudRepository<Account,Long> {

    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);

}
