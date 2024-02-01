package com.example.catalog_server.model;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvNumber;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Catalog {
    @CsvBindByName(column = "ID")
    private long ID;

    @CsvBindByName(column = "PRICE")
    @CsvNumber(value = "#,##0.00")
    private float PRICE;

    @CsvBindByName(column = "QUANTITY")
    @CsvNumber(value = "#,###")
    private int QUANTITY;

    @CsvBindByName(column = "TITLE")
    private String TITLE;

    @CsvBindByName(column = "TOPIC")
    private String TOPIC;
}
