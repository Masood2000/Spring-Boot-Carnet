package com.masood.springbootcarnet.modules.m_14.repository;

import com.masood.springbootcarnet.modules.m_14.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


/***
 * Simple JDBC Repository used by the Spring Data Project
 */
@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

    @Query(value = "SELECT * FROM account WHERE name = :name" , nativeQuery = true)
    List<Account> findAccountsByName(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE account SET amount = :amount WHERE id = :id", nativeQuery = true)
    void changeAmount(long id, BigDecimal amount);

}



