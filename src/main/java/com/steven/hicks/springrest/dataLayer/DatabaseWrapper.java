package com.steven.hicks.springrest.dataLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseWrapper<T>
{
    @Autowired
    JdbcTemplate m_jdbcTemplate = new JdbcTemplate();

    public Object getObject(String query, Object[] args, RowMapper<T> rowMapper)
    {
        return m_jdbcTemplate.queryForObject(query, args, rowMapper);
    }

    public List<T> getObjects(String query, RowMapper<T> rowMapper)
    {
        return m_jdbcTemplate.query(query, rowMapper);
    }

    public void executeDelete(String query, Object objectId)
    {
        m_jdbcTemplate.update(query, objectId);
    }

    public List<T> queryForItems(String query, Object[] args, RowMapper<T> rowMapper)
    {
        return m_jdbcTemplate.query(query, args, rowMapper);
    }

}
