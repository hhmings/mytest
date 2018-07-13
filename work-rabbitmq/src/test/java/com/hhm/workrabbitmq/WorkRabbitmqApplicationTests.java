package com.hhm.workrabbitmq;

import com.hhm.workrabbitmq.rabbitmq_common.enums.QueueEnum;
import com.hhm.workrabbitmq.rabbitmq_provider.MsgProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WorkRabbitmqApplication.class)
public class WorkRabbitmqApplicationTests {
	/**
	 * 消息队列提供者
	 */
	@Autowired
	private MsgProvider msgProvider;


	@Test
	public void test1(){
			msgProvider.sendMsg("测试延迟消费,写入时间："+new Date(),
					QueueEnum.MESSAGE_TTL_QUEUE.getExchange(),
					QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey(),
					10000);
	}


	@Test
	public void contextLoads() {
	}

}
