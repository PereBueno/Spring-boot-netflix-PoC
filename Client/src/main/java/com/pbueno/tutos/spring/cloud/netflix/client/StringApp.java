package com.pbueno.tutos.spring.cloud.netflix.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by POBO on 15/11/2016.
 */
@Configuration
@EnableAutoConfiguration
@RestController
@EnableConfigurationProperties(MyProps.class)
public class StringApp {

    @Autowired
    private Service service;

    @Autowired
    private  MyProps myProps;

    @Value("${myprops.alias:alias!}")
    public String alias;

    @Bean
    @RefreshScope
    public Service service(){
        return new Service(myProps.getName());
    }

    @RequestMapping("/")
    public String home(){
        return "Hello " + service.getName() + "! Alias " + alias;
    }

    public static void main (String[] args){
        SpringApplication.run(StringApp.class, args);
    }
}


class Service{
    private final String name;

    public Service(String name) {
        this.name = name;
    }

    public Service() {
        this.name = "UNKNOWN";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        return name != null ? name.equals(service.name) : service.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                '}';
    }
}
@ConfigurationProperties("myprops")
class MyProps{

    private String name = "World";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyProps myProps = (MyProps) o;

        return name != null ? name.equals(myProps.name) : myProps.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MyProps{" +
                "name='" + name + '\'' +
                '}';
    }
}