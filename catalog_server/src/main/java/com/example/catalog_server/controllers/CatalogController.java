package com.example.catalog_server.controllers;

import com.example.catalog_server.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.catalog_server.services.CatalogService;

import java.util.List;

@RestController
public class CatalogController {

    private final CatalogService service;

    @Autowired
    public CatalogController(CatalogService service){
        this.service = service;
    }

    @GetMapping("/search/{itemTitle}")
    private List<Catalog> getByItem(
            @PathVariable String itemTitle
    ){

        return service.searchItemBySubject(itemTitle);
    }

    @GetMapping("/info/{itemId}")
    private Catalog getBySubject(
            @PathVariable long itemId
    ){
        System.out.println("Testing .....");
        return service.getCatalogInfo(itemId);
    }

    @GetMapping("/catalogs/{catalogId}/quantity")
    private int getCatalogQuantity(
            @PathVariable long catalogId
    ){
       return service.getCatalogQuantity(catalogId);
    }

    @PutMapping("/catalogs/{catalogId}/quantity")
    private void updateCatalogQuantity(
            @PathVariable long catalogId,
            @RequestBody int quantity
    ){
        service.updateCatalogQuantity(catalogId, quantity);
    }

    @PutMapping("/catalogs/{catalogId}")
    private void updateCatalog(
            @PathVariable long catalogId,
            @RequestBody Catalog newCatalog
    ){

       service.updateCatalog(catalogId,newCatalog);

    }

}
