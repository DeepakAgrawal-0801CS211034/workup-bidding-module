package com.workup.biddingModule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.workup.biddingModule.dto.ServiceProviderLoginDTO;
import com.workup.biddingModule.dto.ServiceProviderRegistrationDTO;
import com.workup.biddingModule.model.ServiceProvider;
import com.workup.biddingModule.service.ServiceProviderService;

@RestController
@RequestMapping("/api/service-provider")
public class ServiceProviderController {

    private final ServiceProviderService service;

    public ServiceProviderController(ServiceProviderService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<ServiceProvider> register(@RequestBody ServiceProviderRegistrationDTO dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<ServiceProvider> login(@RequestBody ServiceProviderLoginDTO dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}

