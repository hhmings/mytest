package cn.hhm.worklogcollect.service;

import cn.hhm.worklogcollect.entity.MyLog;

/**
 * @outhor Ming
 * @create 2018-04-04 9:55
 */
public interface LogService {

    void insert(MyLog log);

    void update(MyLog log);
}
