package com.zhoudy.springboot.usermanage.support.mq;

import org.apache.rocketmq.client.producer.SendResult;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class BatchMsgProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult sendBatch(Collection<Integer> ids){
        List<Message> messages = new ArrayList<>(ids.size());
        for (Integer id : ids) {
             BatchMsg msg= new BatchMsg();
             msg.setId(id);
             // 构建 Spring Messaging 定义的 Message 消息
             messages.add(MessageBuilder.withPayload(msg).build());
        }
        // 同步批量发送消息
        return rocketMQTemplate.syncSend(BatchMsg.TOPIC, messages, 30 * 1000L);
    }

}

