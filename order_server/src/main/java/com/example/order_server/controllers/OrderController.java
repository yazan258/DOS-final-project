package com.example.order_server.controllers;

import com.example.order_server.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {


    private OrderService service;

    @Autowired
    public OrderController(OrderService service){
        this.service = service;
    }

    @PostMapping("/purchase/{itemId}")
    private String purchase(
            @PathVariable("itemId") Long itemId
            ){
        return service.purchase(itemId);
    }


}
