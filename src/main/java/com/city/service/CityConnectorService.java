package com.city.service;

import org.springframework.stereotype.Service;

@Service
public interface CityConnectorService {
    boolean isConnected(final String origin, final String destination);
}
