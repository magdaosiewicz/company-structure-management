package com.example.company.configuratioin;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by Magda on 08.05.2018.
 */
@Configuration
@Log4j2
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.company"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)})
public class ContextConfiguration {

}
