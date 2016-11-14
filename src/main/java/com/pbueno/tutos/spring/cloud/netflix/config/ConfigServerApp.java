package com.pbueno.tutos.spring.cloud.netflix.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Pedro on 14/11/2016.
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigServer
public class ConfigServerApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConfigServerApp.class, args);
    }
}
