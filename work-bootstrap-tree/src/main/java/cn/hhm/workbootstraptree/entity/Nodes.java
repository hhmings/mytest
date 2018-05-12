package cn.hhm.workbootstraptree.entity;

import java.util.List;

/**
 * @author Ming
 * @create 2018-04-22 10:33
 */
public class Nodes {

    private String text;
    private String id;
    private Integer isPart;
    private List<Nodes> nodes;

    public Nodes(String text, String id, Integer isPart, List<Nodes> nodes) {
        this.text = text;
        this.id = id;
        this.isPart = isPart;
        this.nodes = nodes;
    }

    public Integer getIsPart() {
        return isPart;
    }

    public void setIsPart(Integer isPart) {
        this.isPart = isPart;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setNodes(List<Nodes> nodes) {
        this.nodes = nodes;
    }
    public List<Nodes> getNodes() {
        return nodes;
    }
}
