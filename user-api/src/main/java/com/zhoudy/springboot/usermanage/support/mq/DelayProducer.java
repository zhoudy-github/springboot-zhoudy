package com.zhoudy.springboot.usermanage.support.mq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class DelayProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    public SendResult delaySyncSend(Integer id,int delayLevel){
        //创建delayMsg消息
        Message message= MessageBuilder.withPayload(new DelayMsg().setId(id)).build();
        //发送同步消息
        return rocketMQTemplate.syncSend(DelayMsg.TOPIC,message,30*1000,delayLevel);
    }

    public void asyncSendDelay(Integer id, int delayLevel, SendCallback callback){
        Message message=MessageBuilder.withPayload(new DelayMsg().setId(id)).build();
        rocketMQTemplate.asyncSend(DelayMsg.TOPIC,message,callback,30*1000,delayLevel);
    }

}
