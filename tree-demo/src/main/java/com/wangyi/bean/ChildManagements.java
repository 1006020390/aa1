package com.wangyi.bean;

public class ChildManagements {
    private Integer id;
    private String child_name;
    private Integer father_id;
    private String tree_url;

    public void setTree_url(String tree_url) {
        this.tree_url = tree_url;
    }

    public String getTree_url() {
        return tree_url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

    public Integer getFather_id() {
        return father_id;
    }

    public void setFather_id(Integer father_id) {
        this.father_id = father_id;
    }

    @Override
    public String toString() {
        return "ChildManagements{" +
                "id=" + id +
                ", child_name='" + child_name + '\'' +
                ", father_id=" + father_id +
                '}';
    }
}
