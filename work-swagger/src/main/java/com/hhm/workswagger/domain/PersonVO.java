package com.hhm.workswagger.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author Ming
 * @create 2018-06-09 14:08
 */
@ApiModel
public class PersonVO {
    @ApiModelProperty(value = "用户主键")
    private Integer id;
    @ApiModelProperty(value = "时间",required = true)
    private Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "PersonVO{" +
                "id=" + id +
                ", create_time=" + create_time +
                '}';
    }
}
