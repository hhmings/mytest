package cn.hhm.workbootstraptree.dao;

import cn.hhm.workbootstraptree.entity.TPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Ming
 * @create 2018-04-22 11:02
 */
@Repository
public interface PartJpa extends JpaRepository<TPart,Integer> {

    List<TPart> findTPartByParentId(Integer parentId);
}
