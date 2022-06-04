package com.backend.rootbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RootBackendApplication.class, args);
    }

}
