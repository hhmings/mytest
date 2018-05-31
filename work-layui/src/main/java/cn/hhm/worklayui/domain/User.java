package cn.hhm.worklayui.domain;

import java.io.Serializable;

/**
 * @author Ming
 * @create 2018-05-26 14:28
 */
public class User implements Serializable{

    private Integer id;
    private String username;
    private String city;

    public User(Integer id, String username, String city) {
        this.id = id;
        this.username = username;
        this.city = city;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
