package com.steven.hicks.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController
{
    @Autowired
    private AmazonPurchaseDAO dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<AmazonPurchase> getPurchases()
    {
        List<AmazonPurchase> allPurchases = dao.getItems();
        return allPurchases;
    }

    @RequestMapping(value = "/id")
    public AmazonPurchase getPurchase(@RequestParam(value = "id")int id)
    {
        AmazonPurchase purchase = dao.getItem(id);
        return purchase;
    }

}
