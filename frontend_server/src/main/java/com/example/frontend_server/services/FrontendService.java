package com.example.frontend_server.services;

import com.example.frontend_server.model.InfoResponce;
import com.example.frontend_server.model.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FrontendService {

    private final RestTemplate restTemplate;

    @Autowired
    public FrontendService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String purchase(Long itemId) {
        String OrderServerURL = "http://localhost:8082/purchase/" + itemId;
       return  restTemplate.postForObject(OrderServerURL,null,String.class);
    }

    public List<SearchResponse> searchItemBySubject(String itemTitle) {
        String catalogServerURL = "http://localhost:8081/search/" + itemTitle;
        return  restTemplate.getForObject(catalogServerURL,List.class);
    }

    public InfoResponce getItemInfo(long itemId) {
        String catalogServerURL = "http://localhost:8081/info/" + itemId;
        return  restTemplate.getForObject(catalogServerURL,InfoResponce.class);
    }
}
