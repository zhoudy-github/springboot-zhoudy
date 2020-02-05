package com.zhoudy.springboot.usermanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.zhoudy.springboot.usermanage.dao")
@EnableSwagger2
public class UsermanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermanageApplication.class, args);
    }

}
