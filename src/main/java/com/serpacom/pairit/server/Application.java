package com.serpacom.pairit.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by deepakga on 12/20/2017.
 */
@SpringBootApplication
@EnableJpaRepositories
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
