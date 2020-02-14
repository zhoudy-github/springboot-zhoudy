
package com.zhoudy.springboot.usermanage.support.task.quartzjdbc;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class QuartzJdbcScheduleConfig {

    /**
     *  JobDetail 和 Trigger 一般是成双成对出现
     */

    //配置QuartzJob01
    public static class Job01Config{
        @Bean
        //创建 QuartzJdbcJob01 的 JobDetail Bean 对象。
        public JobDetail job01Detail(){
            return JobBuilder.newJob(QuartzJdbcJob01.class)
                    // 名字为 demoJob01
                    .withIdentity("QuartzJdbcJob01")
                    // 没有 Trigger 关联的时候任务是否被保留。因为创建 JobDetail 时，
                    // 还没 Trigger 指向它，所以需要设置为 true ，表示保留
                    .storeDurably()
                    .build();
        }
        @Bean
        public Trigger jobTrigger() {
            //简单的调度计划的构造器(创建了每 5 秒执行一次，无限重复的调度计划。)
            SimpleScheduleBuilder simpleScheduleBuilder=SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5)//频率
//                    .repeatForever();//次数
                    .withRepeatCount(2);
            return TriggerBuilder.newTrigger()
                    .forJob(job01Detail())// 对应 Job 为 QuartzJdbcJob01
                    .withIdentity("01JdbcTrigger")// 名字为 QuartzJob01Trigger
                    .withSchedule(simpleScheduleBuilder)// 对应 Schedule 为 scheduleBuilder
                    .build();
        }
    }

    //配置QuartzJob02
    public static class Job02Config{
        @Bean
        //创建 QuartzJdbcJob02 的 JobDetail Bean 对象。
        public JobDetail job02Detail(){
            return JobBuilder.newJob(QuartzJdbcJob02.class)
                    .withIdentity("QuartzJdbcJob02")
                    .storeDurably()
                    .build();
        }
        @Bean
        public Trigger job2Trigger(){
            // 基于 Quartz Cron 表达式的调度计划的构造器(每第 10 秒执行一次的调度计划)
            CronScheduleBuilder cronScheduleBuilder=CronScheduleBuilder.cronSchedule("0/10 * * * * ? *");
            //Trigger构造器
            return TriggerBuilder.newTrigger()
                    .forJob(job02Detail())
                    .withIdentity("02JdbcTrigger")
                    .withSchedule(cronScheduleBuilder)
                    .build();
        }
    }
}

