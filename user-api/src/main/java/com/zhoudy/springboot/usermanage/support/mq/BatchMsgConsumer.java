package com.zhoudy.springboot.usermanage.support.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic= BatchMsg.TOPIC,
        consumerGroup = "consumer-group-"+ BatchMsg.TOPIC
)
@Slf4j
public class BatchMsgConsumer implements RocketMQListener<BatchMsg> {
    @Override
    public void onMessage(BatchMsg msg) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), msg);
    }
}
