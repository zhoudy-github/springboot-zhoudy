package com.zhoudy.springboot.usermanage.task;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTaskTest {

    private final AtomicInteger counts =  new AtomicInteger();

    @Scheduled(fixedRate = 2000)
    @Test
    public void execute(){
        log.info("[execute][定时第 ({}) 次执行]",counts.incrementAndGet());
    }

}
