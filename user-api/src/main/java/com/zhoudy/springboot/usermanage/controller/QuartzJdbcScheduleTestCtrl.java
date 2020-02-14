package com.zhoudy.springboot.usermanage.controller;

import com.zhoudy.springboot.usermanage.support.task.quartzjdbc.QuartzJdbcJob01;
import com.zhoudy.springboot.usermanage.support.task.quartzjdbc.QuartzJdbcJob02;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="quartzCtrl")
@Api(value="QuartzJdbcScheduleTestCtrl",description="定时任务手动设置测试")
public class QuartzJdbcScheduleTestCtrl {

    @Autowired
    private Scheduler scheduler;

    @GetMapping(value = "job01Config")
    @ApiOperation(value="设置job1")
    public void addQuartzJdbcJob01Config() throws SchedulerException{
        //创建JobDetail
        JobDetail jobDetail= JobBuilder
                /*名字*/
                .newJob(QuartzJdbcJob01.class)
                /*//没有 Trigger 关联的时候任务是否被保留。因为创建 JobDetail 时，还没 Trigger 指向它，所以需要设置为 true ，表示保留。*/
                .withIdentity("shouDongshezhiJdbcJob01")
                .storeDurably()
                .build();
        //创建Trigger
        SimpleScheduleBuilder scheduleBuilder=SimpleScheduleBuilder.simpleSchedule()
                /*频率*/
                .withIntervalInSeconds(10)
                /*次数*/
                .withRepeatCount(10);
        Trigger trigger = TriggerBuilder.newTrigger()
                /*对应job*/
                .forJob(jobDetail)
                /*名字*/
                .withIdentity("shouDongshezhiJdbcJob01Trigger")
                /*对应Schedule*/
                .withSchedule(scheduleBuilder)
                .build();
        //添加调度任务
        scheduler.scheduleJob(jobDetail,trigger);
    }

    @GetMapping(value = "job02Config")
    @ApiOperation(value="设置job2")
    public void addQuartzJdbcJob02Config() throws SchedulerException {
        // 创建 JobDetail
        JobDetail jobDetail = JobBuilder.newJob(QuartzJdbcJob02.class)
                .withIdentity("shouDongshezhiJdbcJob02")
                .storeDurably()
                .build();
        // 创建 Trigger
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ? *");
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("shouDongshezhiJdbcJob02Trigger")
                .withSchedule(scheduleBuilder)
                .build();
        // 添加调度任务
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
