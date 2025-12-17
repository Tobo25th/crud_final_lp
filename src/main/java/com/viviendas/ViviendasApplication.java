package com.viviendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories(basePackages = "com.viviendas.Repository")
@EntityScan(basePackages = "com.viviendas")
public class ViviendasApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViviendasApplication.class, args);
        
    }
}