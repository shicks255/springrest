package com.steven.hicks.springrest;

import com.steven.hicks.springrest.dataLayer.DAO;
import com.steven.hicks.springrest.dataLayer.DatabaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        String query = "SELECT * from purchases";
        return m_databaseWrapper.getObjects(query, new AmazonPurchaseRowMapper());
    }

    @Override
    public AmazonPurchase getItem(Object primaryKey)
    {
        String query = "SELECT * from purchases WHERE OBJECT_ID=?";
        AmazonPurchase p =
                (AmazonPurchase)m_databaseWrapper.getObject(query, new Object[]{primaryKey}, new AmazonPurchaseRowMapper());
        return p;
    }

    @Override
    public void deleteItem(Object primaryKey)
    {
        String query = "DELETE from purchases WHERE OBJECT_ID=?";
        m_databaseWrapper.executeDelete(query, primaryKey);
    }

    @Override
    public void updateItem(AmazonPurchase item)
    {
        String query =
                "UPDATE purchases " +
                        "SET ORDER_ID=?,ORDER_DATE=?,YEAR=?,MONTH=?," +
                        "TITLE=?,CATEGORY=?,ITEM_CONDITION=?,SELLER=?,LIST_PRICE=?," +
                        "PURCHASE=?,QUANTITY=?,SHIPPING_ADDRESS=?,TAX=?,ITEM_TOTAL=? " +
                        "where OBJECT_ID=?";

        Object[] args = new Object[]{item.getOrderId(), item.getOrderDate(), item.getYear(), item.getMonth(),
                                    item.getTitle(), item.getCategory(), item.getItemCondition(), item.getSeller(),
                                    item.getPrice(), item.getPurchase(), item.getQuantity(), item.getShippingAddress(),
                                    item.getTax(), item.getItemTotal(), item.getObjectId()};

        m_databaseWrapper.update(query, args);
    }

    @Override
    public List<AmazonPurchase> queryForItems(String query, Object[] args)
    {
        return null;
    }
}

