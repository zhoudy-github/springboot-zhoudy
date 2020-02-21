package com.zhoudy.springboot.usermanage.support.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;


@Component
@RocketMQMessageListener(
        topic = DemoMessage.TOPIC,
        consumerGroup = "consumer-group-" + DemoMessage.TOPIC
)
@Slf4j
public class DemoConsumer implements RocketMQListener<DemoMessage> {
    @Override
    public void onMessage(DemoMessage demoMessage) {
        log.info("收到消息");
        log.info("[onMessage][线程编号：{},消息内容：{}]",Thread.currentThread().getId(),demoMessage);
    }
}
