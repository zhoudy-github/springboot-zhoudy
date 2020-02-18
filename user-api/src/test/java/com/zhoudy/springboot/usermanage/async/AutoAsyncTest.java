package com.zhoudy.springboot.usermanage.async;

import com.zhoudy.springboot.usermanage.Application;
import com.zhoudy.springboot.usermanage.support.async.autoexecution.AutoAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class AutoAsyncTest {

    @Autowired
    private AutoAsyncService autoAsyncService;

    @Test
    public void testExecute() throws InterruptedException {
        autoAsyncService.execute01();
        autoAsyncService.execute02();

        // sleep 1 秒，保证异步调用的执行
        Thread.sleep(1000);
    }
}
