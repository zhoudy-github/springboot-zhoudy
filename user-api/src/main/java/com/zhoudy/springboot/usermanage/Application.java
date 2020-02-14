package com.zhoudy.springboot.usermanage;

import org.mybatis.spring.annotation.MapperScan;
import org.quartz.SchedulerException;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhoudy.springboot.usermanage.dao")
public class Application {
    public static void main(String[] args) throws SchedulerException {
//        SpringApplication.run(UsermanageApplication.class, args);
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
