package com.zhoudy.springboot.usermanage.support.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(
        topic = ShiwuMsg.TOPIC,
        consumerGroup = "consumer-group-" + ShiwuMsg.TOPIC
)
public class ShiwuConsumer implements RocketMQListener<ShiwuMsg> {

    @Override
    public void onMessage(ShiwuMsg shiwuMsg) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), shiwuMsg);
    }
}
