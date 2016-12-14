package com.example.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.eventbus.com.bwie.bean.UserBean;
import com.example.eventbus.com.bwie.com.bwie.view.IUserLoginView;
import com.example.eventbus.com.bwie.presenter.UserLoginPresenter;

public class MainActivity extends AppCompatActivity implements IUserLoginView {
    AutoCompleteTextView tv_email;
    EditText et_password;
    Button btn_email_sign_in_button;
    Button btn_email_clear_button;
    ProgressBar login_progress;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_email = (AutoCompleteTextView) findViewById(R.id.email);
        et_password = (EditText) findViewById(R.id.password);
        btn_email_sign_in_button = (Button) findViewById(R.id.email_sign_in_button);
        btn_email_sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mUserLoginPresenter.login();
            }
        });
        btn_email_clear_button = (Button) findViewById(R.id.email_clear_button);
        btn_email_clear_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mUserLoginPresenter.clear();
            }
        });
        login_progress = (ProgressBar) findViewById(R.id.login_progress);

    }

    @Override
    public String getUserName() {
        // TODO Auto-generated method stub
        return tv_email.getText().toString();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return et_password.getText().toString();
    }

    @Override
    public void clearUserName() {
        // TODO Auto-generated method stub
        tv_email.setText("");
    }

    @Override
    public void clearPassword() {
        // TODO Auto-generated method stub
        et_password.setText("");
    }

    @Override
    public void showLoading() {
        // TODO Auto-generated method stub
        login_progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        // TODO Auto-generated method stub
        login_progress.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserBean user) {
        // TODO Auto-generated method stub
        Toast.makeText(this, user.getUsername() + " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        // TODO Auto-generated method stub
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }
}
