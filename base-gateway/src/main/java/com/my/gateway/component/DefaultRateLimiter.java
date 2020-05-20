package com.my.gateway.component;

import lombok.Data;
import org.springframework.cloud.gateway.filter.ratelimit.AbstractRateLimiter;
import org.springframework.cloud.gateway.support.ConfigurationService;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liu peng bo
 * date: 2020/5/19 14:15
 */
public class DefaultRateLimiter extends AbstractRateLimiter<DefaultRateLimiter.Config> {

    private Map<String, AvailableToken> availableTokensMap = new ConcurrentHashMap<>();


    public DefaultRateLimiter(ConfigurationService configurationService) {
        super(DefaultRateLimiter.Config.class, "default-rate-limiter", configurationService);
    }

    @Override
    public Mono<Response> isAllowed(String routeId, String id) {
        Config config = getConfig().get(routeId);
        AvailableToken availableToken = availableTokensMap.get(id);
        if (availableToken == null) {
            synchronized (this) {
                availableToken = availableTokensMap.get(id);
                if (availableToken == null) {
                    availableToken = new AvailableToken(config);
                    availableTokensMap.put(id, availableToken);
                }
            }
        }
        boolean result = availableToken.isAllowed();
        System.out.println("allowed:"+result);
        return Mono.just(new Response(result, Collections.emptyMap()));
    }

    @Data
    class AvailableToken {
        private long lastFillTime;

        private long availableTokens;

        private Config config;

        private AvailableToken(Config config) {
            this.config = config;
            lastFillTime = Instant.now().getEpochSecond();
            availableTokens = config.getCapacity();
        }

        private synchronized boolean isAllowed() {
            long current = Instant.now().getEpochSecond();
            refill(current);
            if (availableTokens >= config.getRequestToken()) {
                availableTokens = availableTokens - config.getRequestToken();
                return true;
            } else {
                return false;
            }
        }

        private void refill(long current) {
            availableTokens = Math.min(config.getCapacity(), availableTokens + config.getPermitPerSec() * (Math.max(0, current - lastFillTime)));
            lastFillTime = current;
        }


    }


    @Data
    public static class Config {
        private long permitPerSec;

        private long capacity;

        private long requestToken;

    }


}
