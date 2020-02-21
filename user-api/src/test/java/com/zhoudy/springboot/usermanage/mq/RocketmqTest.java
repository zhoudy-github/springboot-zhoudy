package com.zhoudy.springboot.usermanage.mq;


import com.zhoudy.springboot.usermanage.Application;
import com.zhoudy.springboot.usermanage.entity.po.UserInfoPo;
import com.zhoudy.springboot.usermanage.support.mq.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class RocketmqTest {

    @Autowired
    private DemoProducer demoProducer;

    @Autowired
    private BatchMsgProducer msgProducer;

    @Autowired
    private DelayProducer delayProducer;

    @Autowired
    private ChongshiProducer chongshiProducer;

    @Autowired
    private GuangboProducer guangboProducer;

    @Autowired
    private ShunxunProducer shunxunProducer;

    @Autowired
    private ShiwuProduer shiwuProduer;


    @Test
    public void testSyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        String content="我是一条同步的消息";
        SendResult result = demoProducer.syncSend(id,content);
        log.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, result);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testAsyncSend() throws InterruptedException {
        int id=(int)(System.currentTimeMillis()/1000);
        String content="我是一条异步消息";
        demoProducer.asyncSend(id, content, new SendCallback() {
            @Override
            public void onSuccess(SendResult result) {
                log.info("[testASyncSend][发送编号：[{}] 发送成功，结果为：[{}]]", content, result);
            }

            @Override
            public void onException(Throwable e) {
                log.info("[testASyncSend][发送编号：[{}] 发送异常]]", content, e);
            }
        });

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testOnewaySend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        String content="我是消息";
        demoProducer.onewaySend(id,content);
        log.info("[testOnewaySend][发送编号：[{}] 发送完成]", id);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }


    /***
     * 测试批量发送消息
     * @throws InterruptedException
     */
    @Test
    public void testSendBatch () throws InterruptedException {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        SendResult result = msgProducer.sendBatch(ids);
        log.info("[testSendBatch][发送编号：[{}] 发送结果：[{}]]", ids, result);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncSendDelay() throws InterruptedException {
        int id=(int)(System.currentTimeMillis()/10000);
        SendResult result=delayProducer.delaySyncSend(id,3);/// 延迟级别 3 ，即 10 秒后消费
        log.info("[testSyncSendDelay][发送编号：[{}] 发送结果：[{}]]", id, result);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncSendChongshi() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        SendResult result = chongshiProducer.chongshiSyncSend(id);
        log.info("[testSyncSendChongshi][发送编号：[{}] 发送结果：[{}]]", id, result);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }


    @Test
    public void testSyncSendGuangbo() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        SendResult result =guangboProducer.syncSend(9999);
        log.info("[testSyncSendGuangbo][发送编号：[{}] 发送结果：[{}]]", id, result);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }



    @Test
    public void testSyncSendOrderly() throws InterruptedException {
        // 发送多条消息
        for (int i = 0; i < 3; i++) {
            int id = 1024; // 固定成 1024 ，方便我们测试是否发送到相同消息队列
            SendResult result = shunxunProducer.syncSendOrderly(id);
            log.info("[testSyncSendOrderly][发送编号：[{}] 发送结果：[{}]]", id, result);
        }
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testASyncSendOrderly() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int id = 1024; // 固定成 1024 ，方便我们测试是否发送到相同消息队列
            shunxunProducer.asyncSendOrderly(id, new SendCallback() {
                @Override
                public void onSuccess(SendResult result) {
                    log.info("[testASyncSendOrderly][发送编号：[{}] 发送成功，结果为：[{}]]", id, result);
                }
                @Override
                public void onException(Throwable e) {
                    log.info("[testASyncSendOrderly][发送编号：[{}] 发送异常]]", id, e);
                }

            });
        }

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testOnewaySendOrderly() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int id = 1024; // 固定成 1024 ，方便我们测试是否发送到相同消息队列
            shunxunProducer.onewaySendOrderly(id);
            log.info("[testOnewaySendOrderly][发送编号：[{}] 发送完成]", id);
        }
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }



    @Test
    public void testSendMessageInTransaction() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        SendResult result = shiwuProduer.sendMessageInTransaction(id);
        log.info("[testSendMessageInTransaction][发送编号：[{}] 发送结果：[{}]]", id, result);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
