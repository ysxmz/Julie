package com.bjtu.julie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    //创建控件的对象
    private EditText textPhoneNumber;
    private EditText textPassword;
    private EditText textIdentifyingCode;
    private EditText textPrompt;
    private Button buttonLogin;
    private Button btnForget;
    private Button btnReg;
    private CheckBox checkBoxLoginChoose;
    private CheckBox checkBoxRemindPassword;
    private CheckBox checkBoxAutomaticLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        init();//初始化界面

        // 注册按钮，跳转到注册界面
        btnReg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
            }
        });

        // 忘记密码按钮，跳转到忘记密码界面
        btnForget.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });

    }

    /*
    界面初始化
    */
    private void init() {
        //获取注册界面的各个控件
        textPhoneNumber = (EditText) findViewById(R.id.LoginPhoneNumber);
        textPassword = (EditText) findViewById(R.id.LoginPassword);
        buttonLogin = (Button) findViewById(R.id.LoginDetermination);
        btnForget = (Button) findViewById(R.id.Forget);
        btnReg = (Button) findViewById(R.id.NewRegister);
        checkBoxRemindPassword = (CheckBox)findViewById(R.id.LoginRemindPassword);
        checkBoxAutomaticLogin = (CheckBox)findViewById(R.id.AutomaticLogin);
    }
}
