package com.example.resttemplateexample.controller;

import com.example.resttemplateexample.entity.User;
import com.example.resttemplateexample.service.ServiceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    private final ServiceLayer serviceLayer;

    public homeController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping("/")
    public ResponseEntity<User> getData()
    {

        ResponseEntity<User> userResponseEntity = serviceLayer.consumeApi();
        System.out.println(userResponseEntity.getBody());
        System.out.println(userResponseEntity.getStatusCode());
        System.out.println(userResponseEntity.getStatusCodeValue());
        return userResponseEntity;
        // return new ResponseEntity<>(serviceLayer.consumeApi(), HttpStatus.OK);

    }

}
