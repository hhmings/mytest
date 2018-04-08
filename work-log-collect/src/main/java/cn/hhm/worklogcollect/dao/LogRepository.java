package cn.hhm.worklogcollect.dao;

import cn.hhm.worklogcollect.entity.MyLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @outhor Ming
 * @create 2018-04-04 9:55
 */
@Repository
public interface LogRepository extends JpaRepository<MyLog,Long> {
}
