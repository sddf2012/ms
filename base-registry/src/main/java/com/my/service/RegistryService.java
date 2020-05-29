package com.my.service;

import com.my.entity.RegistryServer;

import java.util.List;

/**
 * @author liu peng bo
 * date: 2020/5/25 11:19
 */
public interface RegistryService {
    /**
     * getAll
     *
     * @return List
     */
    List<RegistryServer> getAllValidRegistryServer();

    /**
     * @param zone zone
     * @return List
     */
    List<RegistryServer> getAllValidRegistryServer(String zone);

}
