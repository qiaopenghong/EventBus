package com.example.qiao.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.qiao.eventbus.com.bwie.bean.FirstEvent;

import org.greenrobot.eventbus.EventBus;
/**
*功能:
 * autour: 乔鹏宏
 * date: 2016/12/12 19:17
 * update: 2016/12/12
 */

public class SecondActivity extends AppCompatActivity {
    private Button bt_sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bt_sc = (Button) findViewById(R.id.bt_sc);
        /*
        * 点击发送消息
        */
        bt_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new FirstEvent("我是大鹏"));
            }
        });
    }
}
