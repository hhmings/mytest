package com.hhm.workswagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Ming
 * @create 2018-06-09 10:21
 */
@ApiModel(value = "用户实体类")
public class UserVO {
    @ApiModelProperty(value = "用户主键")
    private Integer uId;
    @ApiModelProperty(value = "用户名",required = true)
    private String username;
    @ApiModelProperty(value = "用户密码",required = true)
    private String pwd;
    @ApiModelProperty(value = "年龄",required = true)
    private Integer age;

    public UserVO(Integer uId, String username, String pwd, Integer age) {
        this.uId = uId;
        this.username = username;
        this.pwd = pwd;
        this.age = age;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "uId=" + uId +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }
}
