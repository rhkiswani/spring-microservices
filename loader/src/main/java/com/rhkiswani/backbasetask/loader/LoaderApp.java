package com.rhkiswani.backbasetask.loader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.rhkiswani.backbasetask")
@EnableScheduling
// had to add the below annotations to force this module to scan the repos / entities before the services
@EnableJpaRepositories("com.rhkiswani.backbasetask.core")
@EntityScan("com.rhkiswani.backbasetask.core")
public class LoaderApp {

    public static void main(String args[]) {
        SpringApplication.run(LoaderApp.class);
    }


}
