package com.example.qiao.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qiao.eventbus.com.bwie.bean.FirstEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * 功能: EventBus
 * autour: 乔鹏宏
 * date: 2016/12/12 11:39
 * update: 2016/12/12
 */
public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //注册EventBus
        EventBus.getDefault().register(this);
        initView();
        //点击跳转
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        bt = (Button) findViewById(R.id.bt);
    }

    //接收消息
    @Subscribe
    public void onEventMainThread(FirstEvent event) {
        String msg = "onEventMainThread收到了消息："+event.getMsg();
        Log.d("harvic",msg);
        tv.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    /**
     * 使用onEvent来接收事件，那么接收事件和分发事件在一个线程中执行
     *
     * @param event
     */
    @Subscribe
    public void onEvent(FirstEvent event) {

    }

    /**
     * 使用onEventBackgroundThread来接收事件，如果分发事件在子线程运行，那么接收事件直接在同样线程
     * 运行，如果分发事件在UI线程，那么会启动一个子线程运行接收事件
     *
     * @param event
     */
    @Subscribe
    public void onEventBackgroundThread(FirstEvent event) {

    }

    /**
     * 使用onEventAsync接收事件，无论分发事件在（UI或者子线程）哪个线程执行，接收都会在另外一个子线程执行
     *
     * @param event
     */
    @Subscribe
    public void onEventAsync(FirstEvent event) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册
        EventBus.getDefault().unregister(this);
    }
}
