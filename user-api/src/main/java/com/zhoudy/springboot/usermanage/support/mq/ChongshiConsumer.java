package com.zhoudy.springboot.usermanage.support.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic=ChongshiMsg.TOPIC,
        consumerGroup = "consumer-group-"+ChongshiMsg.TOPIC
)
@Slf4j
public class ChongshiConsumer implements RocketMQListener<ChongshiMsg> {
    private int i = 1;

    @Override
    public void onMessage(ChongshiMsg chongshiMsg) {
        if(i==3){
            log.info("重试成功");
            log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), chongshiMsg);
        }else{
            log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), chongshiMsg);
            i++;
            log.info("重试");
            // <X> 注意，此处抛出一个 RuntimeException 异常，模拟消费失败
            throw new RuntimeException("我就是故意抛出一个异常");
        }

    }
}
