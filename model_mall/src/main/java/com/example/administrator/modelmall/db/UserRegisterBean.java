package com.example.administrator.modelmall.db;

import org.litepal.crud.DataSupport;

/**
 * Create by SunnyDay on 2019/03/16
 * 用户注册表
 * 存了用户注册的相关信息
 */
public class UserRegisterBean extends DataSupport {

    private String name;
    private String email;
    private String phone;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



}
