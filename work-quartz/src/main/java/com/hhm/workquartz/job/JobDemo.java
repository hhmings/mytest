package com.hhm.workquartz.job;

import com.hhm.workquartz.service.TestService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定义job执行的任务
 *
 * @author Ming
 * @create 2018-06-30 10:31
 */
public class JobDemo extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(JobDemo.class);

    @Autowired
    private TestService testService;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("hello , job    "+name+":"+testService.getStr());
    }
}
