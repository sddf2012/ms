package com.my.goods.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author liu peng bo
 * date: 2020/5/12 15:38
 */
@Configuration
@ConditionalOnProperty(value = "condition.test", havingValue = "123")
public class ConditionTest {
    @Bean
    public Tests tests(List<Test> testList) {
        Tests tests = new Tests();
        tests.setTests(testList);
        return tests;
    }

    @Bean
    public Test test1() {
        Test test1 = new Test();
        return test1;
    }





}
