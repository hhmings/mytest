package cn.hhm.workbootstraptree.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ming
 * @create 2018-04-22 11:00
 */
@Entity
@Table(name = "t_part")
public class TPart  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "partname")
    private String partname;
    @Column(name = "parent_id")
    private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
