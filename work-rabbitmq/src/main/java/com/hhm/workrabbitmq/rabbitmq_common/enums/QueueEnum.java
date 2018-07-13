package com.hhm.workrabbitmq.rabbitmq_common.enums;

import lombok.Getter;

/**
 * 消息队列枚举配置
 * @author Ming
 * @create 2018-07-04 20:56
 */
@Getter
public enum QueueEnum {

    /**
     * 消息通知队列
     */
    MESSAGE_QUEUE("message.center.direct","message.center.create","message.center.create"),

    /**
     * 消息通知TTL队列
     */
    MESSAGE_TTL_QUEUE("message.center.topic.ttl","message.center.create.ttl","message.center.create.ttl");

    /**
     * 交换机名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路邮键
     */
    private String routeKey;

    QueueEnum(String exchange,String name,String routeKey){
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
