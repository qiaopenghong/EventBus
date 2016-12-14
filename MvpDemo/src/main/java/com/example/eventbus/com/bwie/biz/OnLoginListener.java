package com.example.eventbus.com.bwie.biz;

import com.example.eventbus.com.bwie.bean.UserBean;
public interface OnLoginListener {
    void loginSuccess(UserBean user);
    void loginFailed();
}
