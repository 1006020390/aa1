package com.wangyi.bean;

import java.util.List;

public class Managements {
    private Integer id;
    private String managements_name;
    private List<ChildManagements> childManagementsList;

    public void setChildManagementsList(List<ChildManagements> childManagementsList) {
        this.childManagementsList = childManagementsList;
    }

    public List<ChildManagements> getChildManagementsList() {
        return childManagementsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManagements_name() {
        return managements_name;
    }

    public void setManagements_name(String managements_name) {
        this.managements_name = managements_name;
    }

    @Override
    public String toString() {
        return "Managements{" +
                "id=" + id +
                ", managements_name='" + managements_name + '\'' +
                ", childManagementsList=" + childManagementsList +
                '}';
    }
}
