package com.steven.hicks.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
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
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AmazonPurchase getPurchase(@PathVariable("id")int id)
    {
        AmazonPurchase purchase = dao.getItem(id);
        return purchase;
    }

//    UPDATE A PURCHASE
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AmazonPurchase updateAndGetPurchase(@RequestBody MultiValueMap<String, String> form)
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
