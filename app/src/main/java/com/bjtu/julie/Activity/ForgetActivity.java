package com.bjtu.julie.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.bjtu.julie.R;

public class ForgetActivity extends AppCompatActivity {

    //创建控件的对象
    private EditText textPhoneNumber;
    private EditText textIdentifyingCode;
    private Button buttonForgetSet;
    private Button buttonSendMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        init();//初始化界面
    }

    /*
    界面初始化
    */
    private void init() {
        //获取注册界面的各个控件
        textPhoneNumber = (EditText) findViewById(R.id.ForgetPhoneNumber);
        textIdentifyingCode = (EditText) findViewById(R.id.ForgetIdentifyCode);
        buttonForgetSet = (Button) findViewById(R.id.ForgetSet);
        buttonSendMessage = (Button) findViewById(R.id.ForgetSendIdentifyCode);

    }
}
