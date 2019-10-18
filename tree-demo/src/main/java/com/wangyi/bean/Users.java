package com.wangyi.bean;



import java.sql.Timestamp;

public class Users {
    private Integer id;
    private String username;
    private Timestamp createTime;
    private String role_name;
    private String password;
    private Integer authority_level;


    public void setAuthority_level(Integer authority_level) {
        this.authority_level = authority_level;
    }

    public Integer getAuthority_level() {
        return authority_level;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
