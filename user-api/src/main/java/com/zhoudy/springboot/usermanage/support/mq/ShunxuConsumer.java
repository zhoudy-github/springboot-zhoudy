package com.zhoudy.springboot.usermanage.support.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = ShunxuMsg.TOPIC,
        consumerGroup = "consumer-group-"+ShunxuMsg.TOPIC,
        consumeMode = ConsumeMode.ORDERLY//设置为顺序消费
)
@Slf4j
public class ShunxuConsumer implements RocketMQListener<ShunxuMsg> {

    @Override
    public void onMessage(ShunxuMsg shunxuMsg) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), shunxuMsg);

        // sleep 2 秒，用于查看顺序消费的效果
        try {
            Thread.sleep(2 * 1000L);
        } catch (InterruptedException ignore) {
        }
    }
}
