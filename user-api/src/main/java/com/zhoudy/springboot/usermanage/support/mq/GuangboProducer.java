package com.zhoudy.springboot.usermanage.support.mq;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuangboProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSend(Integer id){
        GuangboMsg guangboMsg=new GuangboMsg();
        guangboMsg.setId(id);
        return rocketMQTemplate.syncSend(GuangboMsg.TOPIC,guangboMsg);
    }
}
