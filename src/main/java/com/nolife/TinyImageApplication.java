package com.nolife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.nolife.**.mapper")
@SpringBootApplication
public class TinyImageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyImageApplication.class, args);
    }

}
