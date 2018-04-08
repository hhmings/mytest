package cn.hhm.worklogcollect.dao;

import cn.hhm.worklogcollect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @outhor Ming
 * @create 2018-04-03 17:07
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String name);
}
