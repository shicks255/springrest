package com.steven.hicks.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
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
        AmazonPurchase purchase = dao.getItem(id);
        return purchase;
    }

//    UPDATE A PURCHASE
    @RequestMapping(value = "/{id}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public AmazonPurchase updateAndGetPurchase(@RequestParam MultiValueMap<String,
            Object> form, @PathVariable("id")int id)
    {
        Set<String> formFields = form.keySet();

        AmazonPurchase purchase = dao.getItem(id);

        try
        {
            Class clazz = Class.forName("com.steven.hicks.springrest.AmazonPurchase");
            if (clazz != null)
            {
                List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
                for (Method method : methods)
                {
                    if (method.getName().contains("set"));
                    {
                        String requestName = method.getName();
                        requestName = requestName.replace("set", "");

                    }
                }
            }
        }
        catch (ClassNotFoundException e)
        {

        }

        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePurchase(@PathVariable("id")int id)
    {
        AmazonPurchase purchase = dao.getItem(id);
        if (purchase != null)
            dao.deleteItem(id);
    }

}
