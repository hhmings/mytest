package com.hhm.workrabbitmq.rabbitmq_consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 *
 * @author Ming
 * @create 2018-07-04 22:28
 */
@Component
@RabbitListener(queues = "message.center.create")
public class MsgConsumer {

    private Logger logger = LoggerFactory.getLogger(MsgConsumer.class);


    @RabbitHandler
    public void handler(String content){
        logger.info("消费内容：{}",content);
    }


}
