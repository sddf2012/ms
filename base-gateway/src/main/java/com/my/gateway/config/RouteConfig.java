package com.my.gateway.config;

import com.my.gateway.component.DefaultRateLimiter;
import com.my.gateway.component.UserIdKeyResolver;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ConfigurationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.security.Principal;

/**
 * @author liu peng bo
 * date: 2020/5/13 14:42
 */
@Configuration
public class RouteConfig {

    @Bean
    public UserIdKeyResolver userIdKeyResolver() {
        return new UserIdKeyResolver();
    }

    @Bean
    @Primary
    public DefaultRateLimiter defaultRateLimiter(ConfigurationService configurationService) {
        return new DefaultRateLimiter(configurationService);
    }

    @Bean
    public GlobalFilter customGlobalFilter() {
        return (exchange, chain) ->
                exchange.getPrincipal()
                .map(Principal::getName)
                .defaultIfEmpty("Default User")
                .map(userName -> {
                    //adds header to proxied request
                    exchange.getRequest().mutate().header("CUSTOM-REQUEST-HEADER", userName).build();
                    return exchange;
                })
                .flatMap(chain::filter);
    }

    @Bean
    public GlobalFilter customGlobalPostFilter() {
        return (exchange, chain) -> chain.filter(exchange)
                .then(Mono.just(exchange))
                .map(serverWebExchange -> {
                    //adds header to response
                    serverWebExchange.getResponse().getHeaders().set("CUSTOM-RESPONSE-HEADER",
                            HttpStatus.OK.equals(serverWebExchange.getResponse().getStatusCode()) ? "It worked": "It did not work");
                    return serverWebExchange;
                })
                .then();
    }
}
