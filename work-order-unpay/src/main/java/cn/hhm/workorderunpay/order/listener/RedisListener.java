package cn.hhm.workorderunpay.order.listener;

import cn.hhm.workorderunpay.dao.UserJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

/**
 * @author Ming
 * @create 2018-04-13 14:39
 */
@Component
public class RedisListener extends JedisPubSub {

    Logger logger = LoggerFactory.getLogger(RedisListener.class);

    @Autowired
    private UserJpa userJpa;

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        String substring = message.substring(0, message.indexOf(":"));
        if("ORDER_UNPAY".equals(substring)) {

            String[] strs = message.split(":");
            String deedId = strs[strs.length-1];
            String orderId = strs[strs.length-2];

            logger.error("deedId = "+deedId);
            logger.error("orderId = "+orderId);
            try {
                Thread.sleep(3000);

                if(deedId.matches("[0-9]+")) {
                    System.out.println("代金券信息回滚："+deedId);
                }
                System.out.println("订单id为 "+orderId+"已取消");
                Integer order_id = Integer.parseInt(orderId);
                userJpa.updateUserInfo(order_id,"--H");
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error("为处理的  deedId = "+deedId+"   orderId = "+orderId);
            }
        }
    }
}
