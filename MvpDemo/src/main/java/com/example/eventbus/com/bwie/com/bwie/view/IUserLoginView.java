package com.example.eventbus.com.bwie.com.bwie.view;


import com.example.eventbus.com.bwie.bean.UserBean;

/**
 * view实现接口  
 * @author Administrator
 *
 */
public interface IUserLoginView {
	String getUserName();

	String getPassword();

	void clearUserName();

	void clearPassword();

	void showLoading();

	void hideLoading();

	void toMainActivity(UserBean user);

	void showFailedError();
}
