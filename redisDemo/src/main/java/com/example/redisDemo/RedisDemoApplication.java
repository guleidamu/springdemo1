package com.example.redisDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class RedisDemoApplication {
    public static void  main(String[] args) {
        {
            SpringApplication.run(RedisDemoApplication.class, args);

        }



    }
}
