package com.masood.springbootcarnet.modules.m_12.repository;


import com.masood.springbootcarnet.modules.m_12.model.Purchase;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate mJdbcTemplate;


    @Autowired
    public PurchaseRepository(JdbcTemplate _jdbcTemplate) {
        this.mJdbcTemplate = _jdbcTemplate;
    }

    public List<Purchase> getAllPurchases() {

        String sql = "SELECT * from purchase";

        RowMapper<Purchase> purchaseRowMapper = new RowMapper() {
            @Override
            public @Nullable Object mapRow(ResultSet rs, int rowNum) throws SQLException {

                Purchase rowObject = new Purchase();
                rowObject.setId(rs.getInt("id"));
                rowObject.setProduct(rs.getString("product"));
                rowObject.setPrice(BigDecimal.valueOf(rs.getDouble("price")));

                return rowObject;
            }
        };

        return mJdbcTemplate.query(sql, purchaseRowMapper);

    }

    public BigDecimal insertPurchase(Purchase _purchase) {

        String sql = "INSERT INTO purchase (product, price) VALUES ( ?,?)";

        mJdbcTemplate.update(sql,_purchase.getProduct(),_purchase.getPrice());

        return BigDecimal.ONE;
    }

}
