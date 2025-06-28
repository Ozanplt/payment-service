package com.example.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscoveryController {

    private final DiscoveryClient discoveryClient;

    @Autowired
    public DiscoveryController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/instances")
    public List<ServiceInstance> serviceInstances() {
        // "eureka-server" burada Eureka Server'ın spring.application.name değeri
        return discoveryClient.getInstances("eureka-server");
    }
}