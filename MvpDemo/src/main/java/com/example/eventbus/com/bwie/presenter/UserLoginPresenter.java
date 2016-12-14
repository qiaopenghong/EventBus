package com.example.eventbus.com.bwie.presenter;

import android.os.Handler;

import com.example.eventbus.com.bwie.bean.UserBean;
import com.example.eventbus.com.bwie.biz.IUserBiz;
import com.example.eventbus.com.bwie.biz.OnLoginListener;
import com.example.eventbus.com.bwie.biz.UserBiz;
import com.example.eventbus.com.bwie.com.bwie.view.IUserLoginView;

public class UserLoginPresenter{
	private IUserBiz biz;
	private IUserLoginView loginView;
	private Handler mHandler = new Handler();
	public UserLoginPresenter(IUserLoginView loginView) {
		super();
		this.biz = new UserBiz();
		this.loginView = loginView;
	}

	public void login() {
		loginView.showLoading();
		biz.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
			@Override
			public void loginSuccess(final UserBean user) {
				// 需要在UI线程执行
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						loginView.toMainActivity(user);
						loginView.hideLoading();
					}
				});
			}
			@Override
			public void loginFailed() {
				// TODO Auto-generated method stub
				// 需要在UI线程执行
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						loginView.showFailedError();
						loginView.hideLoading();
					}
				});
			}
		});
	}
	public void clear() {
		loginView.clearUserName();
		loginView.clearPassword();
	}

}
