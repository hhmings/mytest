package cn.hhm.worklogcollect.service;

import cn.hhm.worklogcollect.dao.LogRepository;
import cn.hhm.worklogcollect.entity.MyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @outhor Ming
 * @create 2018-04-04 9:56
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;
    @Override
    public void insert(MyLog log) {
        MyLog myLog = logRepository.save(log);
        System.out.println("添加："+myLog.toString());
    }

    @Override
    public void update(MyLog log) {
        logRepository.save(log);
    }
}
