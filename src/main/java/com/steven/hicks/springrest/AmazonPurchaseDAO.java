package com.steven.hicks.springrest;

import com.steven.hicks.springrest.dataLayer.DAO;
import com.steven.hicks.springrest.dataLayer.DatabaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmazonPurchaseDAO implements DAO<AmazonPurchase>
{
    @Autowired
    DatabaseWrapper m_databaseWrapper;

    @Override
    public List<AmazonPurchase> getItems()
    {
        String query = "select * from purchases";
        return m_databaseWrapper.getObjects(query, new AmazonPurchaseRowMapper());
    }

    @Override
    public AmazonPurchase getItem(Object primaryKey)
    {
        String query = "select * from purchases where OBJECT_ID=?";
        AmazonPurchase p =
                (AmazonPurchase)m_databaseWrapper.getObject(query, new Object[]{primaryKey}, new AmazonPurchaseRowMapper());
        return p;
    }

    @Override
    public void deleteItem(Object primaryKey)
    {
        String query = "delete from purchases where OBJECT_ID=?";
        m_databaseWrapper.executeDelete(query, primaryKey);
    }

    @Override
    public List<AmazonPurchase> queryForItems(String query, Object[] args)
    {
        return null;
    }
}

