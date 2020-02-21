package com.zhoudy.springboot.usermanage.support.mq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShunxunProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public SendResult syncSendOrderly(Integer id){
        ShunxuMsg shunxuMsg = new ShunxuMsg();
        shunxuMsg.setId(id);
        return rocketMQTemplate.syncSendOrderly(ShunxuMsg.TOPIC,shunxuMsg,String.valueOf(id));
    }
    public void asyncSendOrderly(Integer id, SendCallback callback){
        ShunxuMsg shunxuMsg = new ShunxuMsg();
        shunxuMsg.setId(id);
        rocketMQTemplate.asyncSendOrderly(ShunxuMsg.TOPIC,shunxuMsg,String.valueOf(id),callback);
    }

    public void onewaySendOrderly(Integer id){
        ShunxuMsg shunxuMsg = new ShunxuMsg();
        shunxuMsg.setId(id);
        rocketMQTemplate.sendOneWayOrderly(ShunxuMsg.TOPIC,shunxuMsg,String.valueOf(id));
    }
}
