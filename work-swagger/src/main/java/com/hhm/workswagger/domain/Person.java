package com.hhm.workswagger.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ming
 * @create 2018-06-09 10:37
 */
@Entity
@Table(name = "person")
public class Person{

//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "create_time")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", create_time=" + create_time +
                '}';
    }
}
