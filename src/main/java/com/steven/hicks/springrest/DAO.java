package com.steven.hicks.springrest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DAO<T>
{
    List<T> getItems();
    T getItem(Object primaryKey);
    List<T> queryForItems(String query, Object[] args);
}
