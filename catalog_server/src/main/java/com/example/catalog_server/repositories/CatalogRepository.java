package com.example.catalog_server.repositories;

import com.example.catalog_server.model.Catalog;
import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Repository
public class CatalogRepository {


    public List<Catalog> getDataList() {
        try {
            Resource resource = new ClassPathResource("catalog.csv");
            InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            CSVReader csvReader = new CSVReader(reader);

            String[] header = csvReader.readNext(); // Read header
            ColumnPositionMappingStrategy<Catalog> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Catalog.class);

            // Set column mapping with uppercase column names
            strategy.setColumnMapping(header);

            CsvToBean<Catalog> csvToBean = new CsvToBeanBuilder<Catalog>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();

            List<Catalog> dataList = csvToBean.parse();
            return dataList;
        } catch (IOException | com.opencsv.exceptions.CsvException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeDataList(List<Catalog> dataList) {
        try {
            Resource resource = new ClassPathResource("catalog.csv");
            FileWriter fileWriter = new FileWriter(resource.getFile());


            StatefulBeanToCsv<Catalog> beanToCsv = new StatefulBeanToCsvBuilder<Catalog>(fileWriter)
                    .build();

            beanToCsv.write(dataList);
            fileWriter.flush();
            fileWriter.close(); // Close the writer to flush and release resources
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }



}
