package com.steven.hicks.springrest;

import java.util.List;

public interface DAO<T>
{
    List<T> getItems();
    T getItem(Object primaryKey);
    List<T> queryForItems(String query, Object[] args);
}
