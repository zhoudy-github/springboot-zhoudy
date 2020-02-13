package com.zhoudy.springboot.usermanage.support.task.springtask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
//@EnableScheduling
public class ScheduleConfig {

   // @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix("erdaye-");
        //考虑到我们不可能无限等待定时任务全部执行结束，因此可以配置 await-termination-period = 60 ，
        // 等待任务完成的最大时长，单位为秒。具体设置多少的等待时长，可以根据自己应用的需要。
        threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
        //实现应用关闭时，等待定时任务执行完成。这样，应用在关闭的时，Spring 会优先等待
        // ThreadPoolTaskScheduler 执行完任务之后，再开始 Spring Bean 的销毁。
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        return threadPoolTaskScheduler;
    }
}
