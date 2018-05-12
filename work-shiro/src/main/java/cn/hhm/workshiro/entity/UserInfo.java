package cn.hhm.workshiro.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Ming
 * @create 2018-04-26 17:43
 */
@Entity
public class UserInfo implements Serializable{
    @Id
    @GeneratedValue
    private Integer uid;
    @Column(unique = true)
    private String username;//账号
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    private String passwrod;//密码
    private String salt;//加密密码的盐
    //用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    private byte state;

    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中进行加载数据
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roles;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    //密码加盐
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
}
