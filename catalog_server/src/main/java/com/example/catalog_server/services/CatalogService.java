package com.example.catalog_server.services;

import lombok.RequiredArgsConstructor;
import com.example.catalog_server.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalog_server.repositories.CatalogRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {

    @Autowired
    private CatalogRepository repository;


    public List<Catalog> searchItemBySubject(String subject) {
        return repository
                .getDataList()
                .stream()
                .filter(data -> data.getTITLE().contains(subject) || data.getTOPIC().contains(subject))
                .toList();
    }

    public Catalog getCatalogInfo(long catalogId) {

        repository.getDataList().stream().forEach(data -> System.out.println(data.getTITLE()));
        return repository
                .getDataList()
                .stream()
                .filter(data -> data.getID() == catalogId)
                .findAny().orElseThrow();
    }

    public void updateCatalog(long catalogId, Catalog newCatalog) {

        var dataList = repository.getDataList();

        for (Catalog catalog : dataList) {
            if(catalog.getID() == catalogId) {
                catalog.setTOPIC(newCatalog.getTOPIC());
                catalog.setQUANTITY(newCatalog.getQUANTITY());
                catalog.setPRICE(newCatalog.getPRICE());
                catalog.setTITLE(newCatalog.getTITLE());
            }
        }

        repository.writeDataList(dataList);

    }

    public int getCatalogQuantity(long catalogId) {
        return getCatalogInfo(catalogId).getQUANTITY();

    }

    public void updateCatalogQuantity(long catalogId, int quantity) {
        var catalog = getCatalogInfo(catalogId);
        catalog.setQUANTITY(quantity);
        updateCatalog(catalogId,catalog);
    }
}
