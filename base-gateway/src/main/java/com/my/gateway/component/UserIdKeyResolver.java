package com.my.gateway.component;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author liu peng bo
 * date: 2020/5/19 18:13
 */
public class UserIdKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        List<String> userIds = exchange.getRequest().getHeaders().get("userId");
        if (CollectionUtils.isEmpty(userIds)) {
            return Mono.empty();
        }
        return Mono.just(userIds.get(0));
    }
}
