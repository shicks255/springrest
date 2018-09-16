package com.steven.hicks.springrest;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

public class AmazonPurchaseRowMapper implements RowMapper<AmazonPurchase>
{
    @Override
    public AmazonPurchase mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        AmazonPurchase purchase = new AmazonPurchase();
        purchase.setObjectId(rs.getInt("OBJECT_ID"));
        purchase.setOrderId(rs.getString("ORDER_ID"));
        purchase.setOrderDate(rs.getDate("ORDER_DATE").toLocalDate());
        purchase.setYear(rs.getInt("YEAR"));
        purchase.setMonth(rs.getInt("MONTH"));
        purchase.setTitle(rs.getString("TITLE"));
        purchase.setCategory(rs.getString("CATEGORY"));
        purchase.setItemCondition(rs.getString("ITEM_CONDITION"));
        purchase.setSeller(rs.getString("SELLER"));
        purchase.setPrice(rs.getBigDecimal("LIST_PRICE"));
        purchase.setPurchase(rs.getBigDecimal("PURCHASE"));
        purchase.setQuantity(rs.getInt("QUANTITY"));
        purchase.setShippingAddress(rs.getString("SHIPPING_ADDRESS"));
        purchase.setTax(rs.getBigDecimal("TAX"));
        purchase.setItemTotal(rs.getBigDecimal("ITEM_TOTAL"));

        return purchase;
    }
}
