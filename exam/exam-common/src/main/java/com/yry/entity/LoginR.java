package com.yry.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@Component
public class LoginR<T> implements Serializable {
    private T userInfo;
    private List<String> permission;

    public LoginR(Login<T> login){
        this.userInfo = login.getUserInfo();
        this.permission = login.getPermission();
    }
    public LoginR(T userInfo,List<String> permission){
        this.userInfo = userInfo;
        this.permission = permission;
    }

    public LoginR() {
    }

    public T getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(T userInfo) {
        this.userInfo = userInfo;
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }
}

//public class LoginR implements Serializable {
//    private Admin userInfo;
//    private List<String> permission;
//
//    public LoginR(){}
//    public LoginR(Admin login){
//        this.userInfo = login;
//        this.permission = Collections.singletonList(login.getRole());
//    }
//}
