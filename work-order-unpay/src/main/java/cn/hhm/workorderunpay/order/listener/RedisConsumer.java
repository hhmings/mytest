package cn.hhm.workorderunpay.order.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Ming
 * @create 2018-04-13 14:43
 */
@Component
public class RedisConsumer implements CommandLineRunner {

    @Autowired
    private JedisPool jedisPool;
    @Autowired
    RedisListener redisListener;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("RedisConsumer---运行了.....");
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.psubscribe(redisListener, "__key*__:*");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }

    }
}
