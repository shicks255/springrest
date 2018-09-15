package com.steven.hicks.springrest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class AmazonPurchase
{
    private int m_objectId;
    private String m_orderId = "";
    private LocalDate m_orderDate;
    private int m_year;
    private int m_month;
    private String m_title = "";
    private String m_category = "";
    private String m_itemCondition = "";
    private String m_seller = "";
    private BigDecimal m_price;
    private BigDecimal m_purchase;
    private int        m_quantity;
    private String     m_shippingAddress = "";
    private BigDecimal m_tax;
    private BigDecimal m_itemTotal;

    @Override
    public String toString()
    {
        return "Purchase: " + m_objectId + " - " + m_title + " " + m_orderDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmazonPurchase that = (AmazonPurchase) o;
        return m_objectId == that.m_objectId &&
                Objects.equals(m_orderId, that.m_orderId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_objectId, m_orderId);
    }

    public int getObjectId()
    {
        return m_objectId;
    }

    public void setObjectId(int objectId)
    {
        m_objectId = objectId;
    }

    public String getOrderId()
    {
        return m_orderId;
    }

    public void setOrderId(String orderId)
    {
        m_orderId = orderId;
    }

    public LocalDate getOrderDate()
    {
        return m_orderDate;
    }

    public void setOrderDate(LocalDate orderDate)
    {
        m_orderDate = orderDate;
    }

    public int getYear()
    {
        return m_year;
    }

    public void setYear(int year)
    {
        m_year = year;
    }

    public int getMonth()
    {
        return m_month;
    }

    public void setMonth(int month)
    {
        m_month = month;
    }

    public String getTitle()
    {
        return m_title;
    }

    public void setTitle(String title)
    {
        m_title = title;
    }

    public String getCategory()
    {
        return m_category;
    }

    public void setCategory(String category)
    {
        m_category = category;
    }

    public String getItemCondition()
    {
        return m_itemCondition;
    }

    public void setItemCondition(String itemCondition)
    {
        m_itemCondition = itemCondition;
    }

    public String getSeller()
    {
        return m_seller;
    }

    public void setSeller(String seller)
    {
        m_seller = seller;
    }

    public BigDecimal getPrice()
    {
        return m_price;
    }

    public void setPrice(BigDecimal price)
    {
        m_price = price;
    }

    public BigDecimal getPurchase()
    {
        return m_purchase;
    }

    public void setPurchase(BigDecimal purchase)
    {
        m_purchase = purchase;
    }

    public int getQuantity()
    {
        return m_quantity;
    }

    public void setQuantity(int quantity)
    {
        m_quantity = quantity;
    }

    public String getShippingAddress()
    {
        return m_shippingAddress;
    }

    public void setShippingAddress(String shippingAddress)
    {
        m_shippingAddress = shippingAddress;
    }

    public BigDecimal getTax()
    {
        return m_tax;
    }

    public void setTax(BigDecimal tax)
    {
        m_tax = tax;
    }

    public BigDecimal getItemTotal()
    {
        return m_itemTotal;
    }

    public void setItemTotal(BigDecimal itemTotal)
    {
        m_itemTotal = itemTotal;
    }
}
