package com.zhoudy.springboot.usermanage.support.mq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ChongshiProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    public SendResult chongshiSyncSend(Integer id){
        //创建delayMsg消息
        Message message= MessageBuilder.withPayload(new ChongshiMsg().setId(id)).build();
        //发送同步消息
        return rocketMQTemplate.syncSend(ChongshiMsg.TOPIC,message);
    }


}
