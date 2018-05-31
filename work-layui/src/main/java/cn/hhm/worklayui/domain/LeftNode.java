package cn.hhm.worklayui.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 左侧栏菜单列表
 *
 * @author Ming
 * @create 2018-05-26 15:55
 */
public class LeftNode implements Serializable{

private Integer id;
private String title;
private String url;

private List<LeftNode> lists;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<LeftNode> getLists() {
        return lists;
    }

    public void setLists(List<LeftNode> lists) {
        this.lists = lists;
    }
}
