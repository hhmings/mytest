package cn.hhm.worklogcollect.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 配置类
 * @outhor Ming
 * @create 2018-04-04 10:24
 */
@Configuration
public class MyConfig {

    @Bean
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        return executor;
    }
}
