package com.bjtu.julie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegActivity extends AppCompatActivity {

    //创建控件的对象
    private EditText textPhoneNumber;
    private EditText textPassword;
    private EditText textIdentifyingCode;
    private Button buttonRegister;
    private Button buttonSendMessage;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        
        init();//初始化界面
        
    }

    /*
     界面初始化
     */
    private void init() {
        //获取注册界面的各个控件
        textPhoneNumber = (EditText) findViewById(R.id.RegisterPhoneNumber);
        textPassword = (EditText) findViewById(R.id.RegisterPassword);
        textIdentifyingCode = (EditText) findViewById(R.id.RegisterIdentifyingCode);
        buttonRegister = (Button) findViewById(R.id.RegisterDetermination);
        buttonSendMessage = (Button) findViewById(R.id.SendIdentify);

    }
}
