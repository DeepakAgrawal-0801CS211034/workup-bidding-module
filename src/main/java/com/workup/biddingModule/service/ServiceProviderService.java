package com.workup.biddingModule.service;

import com.workup.biddingModule.dto.ServiceProviderLoginDTO;
import com.workup.biddingModule.dto.ServiceProviderRegistrationDTO;
import com.workup.biddingModule.model.ServiceProvider;

public interface ServiceProviderService {

    ServiceProvider register(ServiceProviderRegistrationDTO dto);
    ServiceProvider login(ServiceProviderLoginDTO dto);
}
