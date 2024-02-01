package com.example.frontend_server.controllers;

import com.example.frontend_server.model.InfoResponce;
import com.example.frontend_server.model.SearchResponse;
import com.example.frontend_server.services.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {


    private FrontendService service;

    @Autowired
    public OrderController(FrontendService service){
        this.service = service;
    }


    @GetMapping("/search/{itemTitle}")
    private List<SearchResponse> getByItem(
            @PathVariable String itemTitle
    ){

        return service.searchItemBySubject(itemTitle);
    }

    @GetMapping("/info/{itemId}")
    private InfoResponce getBySubject(
            @PathVariable long itemId
    ){
        System.out.println("Testing .....");
        return service.getItemInfo(itemId);
    }


    @PostMapping("/purchase/{itemId}")
    private String purchase(
            @PathVariable("itemId") Long itemId
            ){
        return service.purchase(itemId);
    }


}
