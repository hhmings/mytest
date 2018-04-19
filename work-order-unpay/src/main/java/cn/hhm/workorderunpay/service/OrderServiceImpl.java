package cn.hhm.workorderunpay.service;

import cn.hhm.workorderunpay.dao.UserJpa;
import cn.hhm.workorderunpay.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Ming
 * @create 2018-04-13 14:18
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserJpa userJpa;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String createOrder(User user) {
        //创建
        User save = userJpa.save(user);
        //缓存到reids

        stringRedisTemplate.opsForValue().set("ORDER_UNPAY:"+user.getId()+":"+user.getSid(),user.toString());
        stringRedisTemplate.expire("ORDER_UNPAY:"+user.getId()+":"+user.getSid(),10, TimeUnit.SECONDS);
        return "ok";
    }
}
