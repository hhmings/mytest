package com.hhm.workquartz.job.config;

import com.hhm.workquartz.job.JobDemo;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

/**
 * Job配置类
 *
 * @author Ming
 * @create 2018-06-30 10:37
 */
@Configuration
public class JobConfig {
    /**
     * 定义定时任务的实例
     *
     * @return
     */
    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(JobDemo.class).withIdentity("JobDemo")
                .storeDurably()
                .usingJobData("name","哈哈")
                .build();
    }

    /**
     * 定义在什么时候执行
     * @return
     */
    @Bean
    public Trigger myJobTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever();

        return TriggerBuilder.newTrigger().forJob(myJobDetail())
                .withIdentity("MyTrigger")
                .withSchedule(simpleScheduleBuilder)
                .build();
    }

}
