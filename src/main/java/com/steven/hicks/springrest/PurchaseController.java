package com.steven.hicks.springrest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/purchases")
public class PurchaseController
{
    @RequestMapping(method = RequestMethod.GET)
    public List<AmazonPurchase> getPurchases()
    {

        return null;
    }

}
