package com.app.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@RocketMQMessageListener(topic = "test-topic", consumerGroup = "provider-user")
@Component
public class ConsumerListener implements RocketMQListener<Object> {

    @Override
    public void onMessage(Object message) {
        System.out.println("接收到消息：" + message.toString()) ;
    }

}
