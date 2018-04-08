package cn.hhm.worklogcollect.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @outhor Ming
 * @create 2018-04-03 18:48
 */
@Entity
@Table(name = "mylogs")
public class MyLog implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主键
    private String type;//日志类型，info，error
    private String title;//操作标题
    @Column(name = "ip_address")
    private String ipAddress;//ip
    @Column(name = "uri_str")
    private String uriStr;//请求路径
    @Column(name = "request_type")
    private String requestType;//请求类型
    @Column(name = "error_info")
    private String errorInfo;//错误信息
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;//操作时间
    @Column(name = "user_id")
    private String userId;//用户id
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;//创建时间

    public MyLog(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUriStr() {
        return uriStr;
    }

    public void setUriStr(String uriStr) {
        this.uriStr = uriStr;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
