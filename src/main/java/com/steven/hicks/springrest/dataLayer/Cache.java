package com.steven.hicks.springrest.dataLayer;

import com.steven.hicks.springrest.AmazonPurchase;

import java.util.concurrent.ConcurrentHashMap;

public class Cache
{
    public static ConcurrentHashMap<Integer, AmazonPurchase> PURCHASE_CACHE
            = new ConcurrentHashMap<>();

    public static AmazonPurchase getFromcache(int id)
    {
        AmazonPurchase purchase = PURCHASE_CACHE.get(id);
        return purchase;
    }

    public static boolean existsInCache(int id)
    {
        return PURCHASE_CACHE.get(id) != null;
    }

    public static void addToCache(AmazonPurchase purchase)
    {
        if (!existsInCache(purchase.getObjectId()))
            PURCHASE_CACHE.put(purchase.getObjectId(), purchase);
    }

}
