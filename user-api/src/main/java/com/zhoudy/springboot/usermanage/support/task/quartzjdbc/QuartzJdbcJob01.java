package com.zhoudy.springboot.usermanage.support.task.quartzjdbc;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@DisallowConcurrentExecution// @DisallowConcurrentExecution 注解，
// 保证相同 JobDetail 在多个 JVM 进程中，有且仅有一个节点在执行。
public class QuartzJdbcJob01 extends QuartzJobBean {

    private static final AtomicInteger counts= new AtomicInteger();

    @Autowired
    private QuartzJdbcJobService quartzJdbcJobServicebcJobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("[executeInternal][定时第 ({}) 次执行, demoService 为 ({})]",counts.incrementAndGet(),quartzJdbcJobServicebcJobService);
    }
}
