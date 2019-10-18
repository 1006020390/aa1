package com.wangyi.bean;

import java.util.List;

public class UserAuthority {
    private List<Integer> managements_id;
    private List<Integer> childManagements_id;
    private Integer id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getManagements_id() {
        return managements_id;
    }

    public void setManagements_id(List<Integer> managements_id) {
        this.managements_id = managements_id;
    }

    public List<Integer> getChildManagements_id() {
        return childManagements_id;
    }

    public void setChildManagements_id(List<Integer> childManagements_id) {
        this.childManagements_id = childManagements_id;
    }

    @Override
    public String toString() {
        return "UserAuthority{" +
                "managements_id=" + managements_id +
                ", childManagements_id=" + childManagements_id +
                ", id=" + id +
                '}';
    }
}
