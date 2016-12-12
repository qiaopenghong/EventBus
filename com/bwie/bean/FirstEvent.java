package com.example.qiao.eventbus.com.bwie.bean;

import java.io.Serializable;

/**
 * 作用：EventBus类
 * 作者：乔鹏宏
 * 时间：2016/12/12
 */

public class FirstEvent implements Serializable{
    private String msg;
    public FirstEvent(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
