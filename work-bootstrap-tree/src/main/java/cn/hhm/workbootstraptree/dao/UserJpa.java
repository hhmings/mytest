package cn.hhm.workbootstraptree.dao;

import cn.hhm.workbootstraptree.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Ming
 * @create 2018-04-22 11:01
 */
@Repository
public interface UserJpa extends JpaRepository<TUser,Integer> {
    List<TUser> findTUserByPid(Integer pid);

//    @Query(value = "select id,username,pid from t_user where pid=?1",nativeQuery = true)
//    List<TUser> getAAAAAA(Integer pid);
}
