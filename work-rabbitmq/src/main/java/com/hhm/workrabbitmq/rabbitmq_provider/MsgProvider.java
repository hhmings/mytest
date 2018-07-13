package com.hhm.workrabbitmq.rabbitmq_provider;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 *
 * @author Ming
 * @create 2018-07-04 22:14
 */
@Component
public class MsgProvider {

    private Logger logger = LoggerFactory.getLogger(MsgProvider.class);

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void sendMsg(Object content,String exchange,String routerKey,long delayTimes){

        logger.info("延迟时间：{}，路由：{}，消息内容：{}",delayTimes,routerKey, JSON.toJSONString(content));
        //发送消息到消息队列
        amqpTemplate.convertAndSend(exchange, routerKey, content, message -> {
            message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
            return message;
        });

    }




}
