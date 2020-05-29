package com.my.config;

import com.my.entity.RegistryServer;
import com.my.service.RegistryService;
import com.my.utils.SpringContextUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * date: 2020/5/25 17:14
 */
@ConfigurationProperties(EurekaClientConfigBean.PREFIX)
public class MyEurekaClientConfigBean extends EurekaClientConfigBean {
    @Override
    public List<String> getEurekaServerServiceUrls(String myZone) {
        RegistryService registryService = SpringContextUtil.getBean(RegistryService.class);
        List<RegistryServer> registryServers = registryService.getAllValidRegistryServer(myZone);
        if (CollectionUtils.isEmpty(registryServers)) {
            registryServers = registryService.getAllValidRegistryServer(EurekaClientConfigBean.DEFAULT_ZONE);
        }
        List<String> urls = new ArrayList<>();
        if (!CollectionUtils.isEmpty(registryServers)) {
            registryServers.forEach(registryServer -> {
                String url = registryServer.getUrl();
                if (!url.endsWith("/")) {
                    url += "/";
                }
                urls.add(url.trim());
            });
        }
        return urls;
    }
}
