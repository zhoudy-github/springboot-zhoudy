package com.zhoudy.springboot.usermanage.support.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = GuangboMsg.TOPIC,
        consumerGroup = "a-consumer-group-" + GuangboMsg.TOPIC,
        messageModel = MessageModel.BROADCASTING // 设置为广播消费
)
@Slf4j
public class GuangboConsumer01 implements RocketMQListener<GuangboMsg> {
    @Override
    public void onMessage(GuangboMsg guangboMsg) {
        log.info("GuangboConsumer01[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), guangboMsg);
    }
}
