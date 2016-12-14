package com.example.eventbus.com.bwie.biz;

public interface IUserBiz {
   void login(
			String username, String password,OnLoginListener loginListener);
}
