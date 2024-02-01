package com.example.order_server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    @Autowired
    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String purchase(Long itemId) {
        // send request to Catalog Server to get item quantity
        String catalogUrl = "http://localhost:8081/catalogs/" + itemId + "/quantity";
        Integer itemsQuantity = restTemplate.getForObject(catalogUrl, Integer.class);

        if (itemsQuantity != null && itemsQuantity > 0) {
            // Send request to Catalog Server to decrement item quantity
             restTemplate.put(catalogUrl,itemsQuantity-1);
             return "Item Purchased Successfully";
        } else {
            return "Item not available in stock";
        }
    }
}
