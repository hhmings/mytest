package com.hhm.workquartz.service.impl;

import com.hhm.workquartz.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author Ming
 * @create 2018-06-30 11:00
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getStr() {
        return "aa";
    }
}
