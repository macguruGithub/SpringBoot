package org.example;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate getResTemplate(){
        System.out.println("** restTemplate created  **");
        return new RestTemplate();
    }
}
