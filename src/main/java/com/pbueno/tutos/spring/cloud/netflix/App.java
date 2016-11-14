package com.pbueno.tutos.spring.cloud.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pedro on 14/11/2016.
 */
@Configuration
@RestController
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

}
