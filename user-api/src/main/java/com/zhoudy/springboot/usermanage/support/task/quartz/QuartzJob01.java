package com.zhoudy.springboot.usermanage.support.task.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class QuartzJob01 extends QuartzJobBean {

    private static final AtomicInteger counts= new AtomicInteger();

    @Autowired
    private QuartzJobService quartzJobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("[executeInternal][定时第 ({}) 次执行, demoService 为 ({})]",counts.incrementAndGet(),quartzJobService);
    }
}
