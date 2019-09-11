package com.config.clientdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClientdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientdemoApplication.class, args);
    }

    @Value("${sck.user}")
    String sckUser;
    @Value("${sck.password}")
    String sckPassword;

    @RequestMapping("/hello")
    public String showUserAndPassword(){
        String sb = "username is " + sckUser + "," + "password is " +sckPassword;
        return sb;
    }
}

