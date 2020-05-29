package com.my.service.impl;

import com.my.entity.RegistryServer;
import com.my.repository.RegistryServerRepository;
import com.my.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liu peng bo
 * date: 2020/5/25 11:23
 */
@Service
public class RegistryServiceImpl implements RegistryService {

    private final String defaultZone = "defaultZone";
    private final Integer valid = 1;
    private final Integer invalid = 0;


    @Autowired
    private RegistryServerRepository repository;

    @Override
    public List<RegistryServer> getAllValidRegistryServer() {
        return repository.findByStatus(valid);
    }

    @Override
    public List<RegistryServer> getAllValidRegistryServer(String zone) {
        return repository.findByZoneAndStatus(zone, valid);
    }
}
