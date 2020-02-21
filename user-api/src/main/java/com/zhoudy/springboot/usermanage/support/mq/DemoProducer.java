package com.zhoudy.springboot.usermanage.support.mq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DemoProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    /****
     * 生产者发送消息有三种方式
     *
     * 同步（Sync）：发送方线程发送后同步堵塞等待SendResult，若failed则重试下一个broker
     * 异步（Async）：发送方线程发送后无需等待返回结果（返回的是null），当Broker返回结果后，
     *                生产者使用回调函数异步处理，超时可抛出Timeout异常
     * 单向（OneWay）：发送方不等待broker响应也没有回调函数触发，速度快但可靠性弱
     *参数	默认值	解释
     * defaultTopicQueueNums	4	一个主题创建4个消息队列
     * sendMsgTimeout	3000ms	发送消息超时时间
     * compressMsgBodyOverHowmuch	4K	消息体（Msg Body）长度超过4K，需要压缩
     * retryTimesWhenSendFailed	2	同步模式下消息发送失败重试次数
     * retryTimesWhenSendAsyncFailed	2	异步模式下消息发送失败重试次数
     * maxMessageSize	4M	消息最大长度
     *
     * @param id
     * @param str
     * @return
     */

    public SendResult syncSend(Integer id,String str){
        DemoMessage message = new DemoMessage();
        message.setId(id);
        message.setContent(str);
        // 同步发送消息
        return rocketMQTemplate.syncSend(DemoMessage.TOPIC, message);
    }

    public void asyncSend(Integer id,String str,SendCallback callback) {
        DemoMessage message = new DemoMessage();
        message.setId(id);
        message.setContent(str);
        // 异步发送消息
        rocketMQTemplate.asyncSend(DemoMessage.TOPIC, message, callback);
    }

    public void onewaySend(Integer id,String str) {
        DemoMessage message = new DemoMessage();
        message.setId(id);
        message.setContent(str);
        // oneway 发送消息
        rocketMQTemplate.sendOneWay(DemoMessage.TOPIC, message);
    }

}
