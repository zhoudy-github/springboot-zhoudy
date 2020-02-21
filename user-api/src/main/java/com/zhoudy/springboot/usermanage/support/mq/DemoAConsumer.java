package com.zhoudy.springboot.usermanage.support.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;


/***
 * 发送一条 Topic 为 "DEMO_01" 的消息，
 * 可以分别被 "zhoudy-consumer-group-DEMO_01" 和 "a-zhoudy-consumer-group-DEMO_01" 都消费一次。
 * 通过集群消费的机制，我们可以实现针对相同 Topic ，不同消费者分组实现各自的业务逻辑。
 * 例如说：用户注册成功时，发送一条 Topic 为 "USER_REGISTER" 的消息。然后
 * 不同模块使用不同的消费者分组，订阅该 Topic ，实现各自的拓展逻辑：
 */

/***
 * 实现 RocketMQListener 接口，在 T 泛型里，设置消费的消息对应的类不是 Demo01Message 类，
 * 而是 RocketMQ 内置的 MessageExt 类。通过 MessageExt 类，我们可以获取到消费的消息的更多信息，
 * 例如说消息的所属队列、创建时间等等属性，
 * 不过消息的内容(body)就需要自己去反序列化。当然，一般情况下，我们不会使用 MessageExt 类。
 */
@Component
@RocketMQMessageListener(
        topic = DemoMessage.TOPIC,
        consumerGroup = "a-consumer-group-" + DemoMessage.TOPIC
)
@Slf4j
public class DemoAConsumer implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt messageExt) {
        log.info("a收到消息");
        log.info("[onMessage][线程编号：{},消息内容：{}]",Thread.currentThread().getId(),messageExt);
    }
}
