package com.example.resttemplateexample.service;

import com.example.resttemplateexample.entity.User;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@Component
public class ServiceLayer {

    private final RestTemplate restTemplate;

    public ServiceLayer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public ResponseEntity<User> consumeApi()
    {
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity=new HttpEntity<>(headers);
        System.out.println(requestEntity.getClass())    ;
        System.out.println(requestEntity.getBody());
        System.out.println(requestEntity.getHeaders());

        //  return restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke",String.class);
       // return restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke",User.class);
        return  restTemplate.exchange("https://official-joke-api.appspot.com/random_joke", HttpMethod.GET,requestEntity,User.class);
    }
}
