package com.hhm.workswagger.dao;

import com.hhm.workswagger.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ming
 * @create 2018-06-09 14:02
 */
public interface PersonJpa extends JpaRepository<Person,Integer> {

}
