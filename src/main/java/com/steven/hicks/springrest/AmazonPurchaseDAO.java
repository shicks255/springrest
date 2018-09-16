package com.steven.hicks.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmazonPurchaseDAO implements DAO<AmazonPurchase>
{
    @Autowired
    JdbcTemplate m_jdbcTemplate;

    @Override
    public JdbcTemplate getJdbcTemplate()
    {
        return m_jdbcTemplate;
    }

    @Override
    public List<AmazonPurchase> getItems()
    {
        return m_jdbcTemplate.query("select * from purchases", new AmazonPurchaseRowMapper());
    }

    @Override
    public AmazonPurchase getItem(Object primaryKey)
    {
        String query = "select * from purchases where objectId=?";
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

