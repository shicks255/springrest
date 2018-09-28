package com.steven.hicks.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/purchases")
public class PurchaseController
{
    @Autowired
    private AmazonPurchaseDAO dao;

//    GET ALL PURCHASES
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AmazonPurchase> getPurchases()
    {
        List<AmazonPurchase> allPurchases = dao.getItems();
        return allPurchases;
    }

//    MAKE A PURCHASE
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void makePurchase()
    {

    }

//    GET A PURCHASE
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AmazonPurchase getPurchase(@PathVariable("id")int id)
    {
        long currentTime = System.currentTimeMillis();
        AmazonPurchase purchase = dao.getItem(id);
        System.out.println("Took " + (System.currentTimeMillis()-currentTime));
        return purchase;
    }

//    UPDATE A PURCHASE
    @RequestMapping(value = "/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public AmazonPurchase updateAndGetPurchase(@RequestParam MultiValueMap<String,
            Object> form, @PathVariable("id")int id)
    {
        AmazonPurchase purchase = dao.getItem(id);

        Integer month = Integer.valueOf((String)form.get("month").get(0));
        if (month != null) purchase.setMonth(month);

        Integer year = Integer.valueOf((String)form.get("year").get(0));
        if (year != null) purchase.setYear(year);

        String purchaseAmount = (String)form.get("purchase").get(0);
        if (purchaseAmount != null) purchase.setPurchase(new BigDecimal(purchaseAmount));

        String category = (String)form.get("category").get(0);
        if (category != null) purchase.setCategory(category);

        String condition = (String)form.get("itemCondition").get(0);
        if (condition != null) purchase.setItemCondition(condition);

        String orderId = (String)form.get("orderId").get(0);
        if (orderId != null) purchase.setOrderId(orderId);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate orderDate = LocalDate.parse((String)form.get("orderDate").get(0), dtf);
        if (orderDate != null) purchase.setOrderDate(orderDate);

        String title = (String)form.get("title").get(0);
        if (title != null) purchase.setTitle(title);

        String seller = (String)form.get("seller").get(0);
        if (seller != null) purchase.setSeller(seller);

        BigDecimal  total = new BigDecimal((String)form.get("itemTotal").get(0));
        if (total != null) purchase.setItemTotal(total);

        Integer quantity = Integer.valueOf((String)form.get("quantity").get(0));
        if (quantity != null) purchase.setQuantity(quantity);

        BigDecimal tax = new BigDecimal((String)form.get("tax").get(0));
        if (tax != null) purchase.setTax(tax);

        BigDecimal price = new BigDecimal((String)form.get("price").get(0));
        if (price != null) purchase.setPrice(price);

        String address = (String)form.get("shippingAddress").get(0);
        if (address != null) purchase.setShippingAddress(address);

        dao.updateItem(purchase);

        return purchase;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePurchase(@PathVariable("id")int id)
    {
        AmazonPurchase purchase = dao.getItem(id);
        if (purchase != null)
            dao.deleteItem(id);
    }

}
