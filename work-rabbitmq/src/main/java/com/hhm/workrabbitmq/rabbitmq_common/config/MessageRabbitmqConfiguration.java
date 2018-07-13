package com.hhm.workrabbitmq.rabbitmq_common.config;

import com.hhm.workrabbitmq.rabbitmq_common.enums.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息通知 - 消息队列配置信息
 * @author Ming
 * @create 2018-07-04 21:08
 */
@Configuration
public class MessageRabbitmqConfiguration {

    /**
     * 消息中心实际消费队列交换配置(Exchange)
     * @return
     */
    @Bean
    public DirectExchange messageDirect(){
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.MESSAGE_QUEUE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 消息中心 延迟消费交换配置(Exchange)
     * @return
     */
    @Bean
    public DirectExchange messageTtlDirect(){
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.MESSAGE_TTL_QUEUE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 消息中心 实际消费队列(queue)
     * @return
     */
    @Bean
    public Queue messageQueue(){
        return new Queue(QueueEnum.MESSAGE_QUEUE.getName());
    }

    /**
     * 消息中心 TTL队列(queue)
     * @return
     */
    @Bean
    public Queue messageTtlQueue(){
        return QueueBuilder
                .durable(QueueEnum.MESSAGE_TTL_QUEUE.getName())
                //配置到期后转发的交换
                .withArgument("x-dead-letter-exchange",QueueEnum.MESSAGE_QUEUE.getExchange())
                // 配置到期后转发的路由键
                .withArgument("x-dead-letter-routing-key", QueueEnum.MESSAGE_QUEUE.getRouteKey())
                .build();
    }

    /**
     *消费交换机和消费队列的绑定
     * @param messageDirect 消费交换机
     * @param messageQueue 消费队列
     * @return
     */
    @Bean
    public Binding messageBinding(DirectExchange messageDirect,Queue messageQueue){
        return BindingBuilder
                .bind(messageQueue)
                .to(messageDirect)
                .with(QueueEnum.MESSAGE_QUEUE.getRouteKey());
    }

    /**
     * 延迟交换机和延迟队列的绑定
     * @param messageTtlDirect 延迟交换机
     * @param messageTtlQueue 延迟队列
     * @return
     */
    @Bean
    public Binding messageTtlBinding(DirectExchange messageTtlDirect,Queue messageTtlQueue){
        return BindingBuilder
                .bind(messageTtlQueue)
                .to(messageTtlDirect)
                .with(QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey());
    }

}
