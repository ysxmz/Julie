package com.bjtu.julie.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bjtu.julie.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;


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
        x.view().inject(this);//绑定注解
        init();//初始化界面
        /**
         * 注册按钮点击事件，向服务器发出请求，返回结果
         */
       buttonRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               /**
                * 服务器地址，传递两个参数
                */
               String url = "http://39.107.225.80:8080/julieServer/RegisterServlet";
               RequestParams params = new RequestParams(url);
               params.addParameter("username", textPhoneNumber.getText().toString());
               params.addParameter("password", textPassword.getText ().toString());
               x.http().get(params, new Callback.CommonCallback<String>() {
                   public void onSuccess(String result) {
                       try {
                           JSONObject jb = new JSONObject(result);
                           //Log.i("AAA", String.valueOf(jb.getInt("code"))+jb.getString("msg"));
                           Toast.makeText(x.app(), jb.getString("msg"), Toast.LENGTH_LONG).show();

                       } catch (JSONException e) {
                           e.printStackTrace();
                       }
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
