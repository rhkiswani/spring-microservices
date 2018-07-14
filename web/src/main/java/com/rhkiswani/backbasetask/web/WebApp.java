package com.rhkiswani.backbasetask.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.rhkiswani.backbasetask")
@EnableScheduling
// had to add the below annotations to force this module to scan the repos / entities before the services
@EnableJpaRepositories("com.rhkiswani.backbasetask.core")
@EntityScan("com.rhkiswani.backbasetask.core")
public class WebApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApp.class);
    }

    public static void main(String args[]) {
        SpringApplication.run(WebApp.class);
    }

}
