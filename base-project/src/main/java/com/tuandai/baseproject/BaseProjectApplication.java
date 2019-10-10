package com.tuandai.baseproject;

import com.cxytiandi.encrypt.anno.EnableEncrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@EnableEncrypt
@SpringBootApplication
@EnableAutoConfiguration
public class BaseProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseProjectApplication.class, args);
    }
}
