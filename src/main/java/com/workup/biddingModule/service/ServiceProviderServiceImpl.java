package com.workup.biddingModule.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import com.workup.biddingModule.dto.ServiceProviderRegistrationDTO;
import com.workup.biddingModule.model.ServiceProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.workup.biddingModule.repository.ServiceProviderRepository;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    private final ServiceProviderRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ServiceProviderServiceImpl(ServiceProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceProvider register(ServiceProviderRegistrationDTO dto) {
        ServiceProvider provider = new ServiceProvider();
        provider.setFirstName(dto.getFirstName());
        provider.setMiddleName(dto.getMiddleName());
        provider.setLastName(dto.getLastName());
        provider.setEmail(dto.getEmail());
        provider.setPassword(passwordEncoder.encode(dto.getPassword()));
        provider.setPhoneNumber(dto.getPhoneNumber());
        provider.setImgURL(dto.getImgURL());
        provider.setImgPublicId(dto.getImgPublicId());
        provider.setStartingPrice(dto.getStartingPrice());
        provider.setCategory(dto.getCategory());
        provider.setSubcategories(dto.getSubcategories());
        provider.setLanguages(dto.getLanguages());
        provider.setInfo(dto.getInfo());
        provider.setVerificationStatus("pending");
        provider.setActivityStatus("active");
        provider.setJoiningDate(LocalDateTime.now());

        return repository.save(provider);
    }

    @Override
    public ServiceProvider login(ServiceProviderLoginDTO dto) {
        return repository.findByEmail(dto.getEmail())
                .filter(provider -> passwordEncoder.matches(dto.getPassword(), provider.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }
}

