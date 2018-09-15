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
        purchase.setObjectId(rs.getInt("m_objectId"));
        purchase.setOrderId(rs.getString("m_orderId"));
        purchase.setOrderDate(rs.getDate("m_orderDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        purchase.setYear(rs.getInt("m_year"));
        purchase.setMonth(rs.getInt("m_month"));
        purchase.setTitle(rs.getString("m_title"));
        purchase.setCategory(rs.getString("m_category"));
        purchase.setItemCondition(rs.getString("m_itemCondition"));
        purchase.setSeller(rs.getString("m_seller"));
        purchase.setPrice(rs.getBigDecimal("m_price"));
        purchase.setPurchase(rs.getBigDecimal("m_purchase"));
        purchase.setQuantity(rs.getInt("m_quantity"));
        purchase.setShippingAddress(rs.getString(rs.getString("m_shippingAddress")));
        purchase.setTax(rs.getBigDecimal("m_tax"));
        purchase.setItemTotal(rs.getBigDecimal("m_itemTotal"));

        return purchase;
    }
}
