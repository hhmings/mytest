package com.hhm.workshirodemo.domain;

/**
 * @author Ming
 * @create 2018-07-12 14:59
 */
public class SysMsg {
    private int id;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "SysMsg{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                '}';
    }
}
