package com.example.eventbus.com.bwie.biz;
import com.example.eventbus.com.bwie.bean.UserBean;

public class UserBiz implements IUserBiz{
	@Override
	public void login(final String username, final String password, final OnLoginListener loginListener) {
		// TODO Auto-generated method stub
		// 模拟子线程耗时操作
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 模拟登录成功
				if ("27808342@qq.com".equals(username) && "3838438".equals(password)) {
					UserBean user = new UserBean(username, password);
					loginListener.loginSuccess(user);
				} else {
					loginListener.loginFailed();
				}
			}
	}.start();
	}
}
