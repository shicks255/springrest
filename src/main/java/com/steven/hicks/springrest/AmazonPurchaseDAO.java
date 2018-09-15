package com.steven.hicks.springrest;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AmazonPurchaseDAO implements DAO<AmazonPurchase>
{

    private static JdbcTemplate m_jdbcTemplate = new JdbcTemplate();

    @Override
    public List<AmazonPurchase> getItems()
    {
        return null;
    }

    @Override
    public AmazonPurchase getItem(Object primaryKey)
    {
        String query = "select * from AmazonPurchase where objectId=?";
        return m_jdbcTemplate.queryForObject(query,
                new Object[]{primaryKey},
                new AmazonPurchaseRowMapper());
    }

    @Override
    public List<AmazonPurchase> queryForItems(String query, Object[] args)
    {
        return m_jdbcTemplate.query(query,
                args,
                new AmazonPurchaseRowMapper());
    }
}

