package com.masood.springbootcarnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = DataSourceAutoConfiguration.class
)
public class SpringBootCarnetApplication {

    public static void main(String[] args) {


        SpringApplication.run(SpringBootCarnetApplication.class, args);

    }

}