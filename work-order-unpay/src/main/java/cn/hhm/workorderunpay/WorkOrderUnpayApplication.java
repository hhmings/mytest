package cn.hhm.workorderunpay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
public class WorkOrderUnpayApplication {

	@Value("${spring.redis.host}")
	private String ip;

	@Bean
	public JedisPool jedisPool(){
		JedisPool pool = new JedisPool(new JedisPoolConfig(),ip);
		return pool;
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkOrderUnpayApplication.class, args);
	}
}
