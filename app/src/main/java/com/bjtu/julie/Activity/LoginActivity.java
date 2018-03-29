package com.bjtu.julie.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bjtu.julie.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

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
        /**
         * 登陆按钮点击事件
         */
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://39.107.225.80:8080/julieServer/LoginServlet";
                RequestParams params = new RequestParams(url);
                params.addParameter("username", textPhoneNumber.getText().toString());
                params.addParameter("password", textPassword.getText().toString());
                x.http().get(params, new Callback.CommonCallback<String>() {

                    public void onSuccess(String result) {
                        Toast.makeText(x.app(), result, Toast.LENGTH_LONG).show();
                        Log.i("JAVA", "onSuccess result:" + result);

                    }

                    //请求异常后的回调方法
                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                    }

                    //主动调用取消请求的回调方法
                    @Override
                    public void onCancelled(CancelledException cex) {
                    }

                    @Override
                    public void onFinished() {

                    }
                });
            }
        });

        // 注册按钮，跳转到注册界面
        btnReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
            }
        });

        // 忘记密码按钮，跳转到忘记密码界面
        btnForget.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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
        checkBoxRemindPassword = (CheckBox) findViewById(R.id.LoginRemindPassword);
        checkBoxAutomaticLogin = (CheckBox) findViewById(R.id.AutomaticLogin);
    }
}
