package com.my.repository;

import com.my.entity.RegistryServer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liu peng bo
 * date: 2020/5/25 11:24
 */
public interface RegistryServerRepository extends JpaRepository<RegistryServer, Integer> {
    List<RegistryServer> findByStatus(Integer status);

    List<RegistryServer> findByZoneAndStatus(String zone,Integer status);
}
