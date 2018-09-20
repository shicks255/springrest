package com.steven.hicks.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping("/{id}")
    public AmazonPurchase getPurchase(@PathVariable("id")int id)
    {
        AmazonPurchase purchase = dao.getItem(id);
        return purchase;
    }

//    UPDATE A PURCHASE
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public AmazonPurchase updateAndGetPurchase(@PathVariable("id")int id)
    {

        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePurchase(@PathVariable("id")int id)
    {
        AmazonPurchase purchase = dao.getItem(id);
        //then delete the purchase, need dao logic
    }

}
