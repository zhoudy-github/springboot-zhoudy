package com.zhoudy.springboot.usermanage.task;


import com.zhoudy.springboot.usermanage.Application;
import com.zhoudy.springboot.usermanage.support.task.quartzjdbc.QuartzJdbcJob01;
import com.zhoudy.springboot.usermanage.support.task.quartzjdbc.QuartzJdbcJob02;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class QuartzJdbcScheduleTest {
    @Autowired
    private Scheduler scheduler;

    @Test
    public void addQuartzJdbcJob01Config() throws SchedulerException{
        //创建JobDetail
        JobDetail jobDetail= JobBuilder
                /*名字*/
                .newJob(QuartzJdbcJob01.class)
                /*//没有 Trigger 关联的时候任务是否被保留。因为创建 JobDetail 时，还没 Trigger 指向它，所以需要设置为 true ，表示保留。*/
                .withIdentity("JdbcJob01")
                .storeDurably()
                .build();
        //创建Trigger
        SimpleScheduleBuilder scheduleBuilder=SimpleScheduleBuilder.simpleSchedule()
                /*频率*/
                .withIntervalInSeconds(5)
                /*次数*/
        .withRepeatCount(5);
        Trigger trigger = TriggerBuilder.newTrigger()
                /*对应job*/
                .forJob(jobDetail)
                /*名字*/
                .withIdentity("JdbcJob01Trigger")
                /*对应Schedule*/
                .withSchedule(scheduleBuilder)
                .build();
        //添加调度任务
        scheduler.scheduleJob(jobDetail,trigger);
    }
    @Test
    public void addQuartzJdbcJob02Config() throws SchedulerException {
        // 创建 JobDetail
        JobDetail jobDetail = JobBuilder.newJob(QuartzJdbcJob02.class)
                .withIdentity("JdbcJob02")
                .storeDurably()
                .build();
        // 创建 Trigger
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ? *");
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("JdbcJob02Trigger")
                .withSchedule(scheduleBuilder)
                .build();
        // 添加调度任务
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
