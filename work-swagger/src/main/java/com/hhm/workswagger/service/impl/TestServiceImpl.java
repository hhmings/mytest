package com.hhm.workswagger.service.impl;

import com.hhm.workswagger.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Ming
 * @create 2018-06-09 8:56
 */
@Service
public class TestServiceImpl implements TestService {

    private Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public void test() {
        log.error("TestServiceImpl 执行 test() 方法.....");
    }
}
