package cn.hhm.workbootstraptree.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ming
 * @create 2018-04-22 10:58
 */
@Entity
@Table(name = "t_user")
public class TUser implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "pid")
    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
