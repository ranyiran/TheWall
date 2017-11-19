package com.ran.thewal.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ran.thewal.R;
import com.ran.thewal.bean.AccountUser;
import com.ran.thewal.utils.I2GO;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * @作者 Ranyiran
 * @介绍 登陆界面的实现
 * @时间 2017/11/19 14:41
 * <p/>
 * 实现用手机号码和密码登陆。
 * 登陆后跳转到MainActivity里面去。
 * 通过SplashActivity直接进入Login界面。判断是否缓存里面有账号登陆
 * Y:直接进入MainActivity界面
 * <p/>
 * N:进入登陆界面同时给出注册界面的按钮
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText metUsername, metPassword;
    private Button mbtnLogin, mbtnReg;
    Context mContext;
    String password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        isLogin();
        setListener();
    }

    /**
     * 设置监听事件
     */
    private void setListener() {
        mbtnLogin.setOnClickListener(this);
        mbtnReg.setOnClickListener(this);
    }

    /**
     * 绑定控件 初始化
     */
    private void initView() {
        mContext = this;
        metUsername = (EditText) findViewById(R.id.logEtUsername);
        metPassword = (EditText) findViewById(R.id.logEtPassword);
        mbtnLogin = (Button) findViewById(R.id.logBtnLogin);
        mbtnReg = (Button) findViewById(R.id.logBtnReg);
    }

    /**
     * 判断本地是否保存登陆状态。
     * Y:跳转到MainActivity
     * N:留在本地
     */
    public void isLogin() {
        BmobUser user = AccountUser.getCurrentUser(mContext);
        if (user != null) {
            //跳转到MainActivity
            I2GO.Go2MainActivity((Activity) mContext);
            ((Activity) mContext).finish();
        } else {
            return;
        }
    }

    @Override
    public void onClick(View v) {
        final ProgressDialog dialog = new ProgressDialog(mContext);
        username = metUsername.getText().toString().trim();
        password = metPassword.getText().toString().trim();
        switch (v.getId()) {
            case R.id.logBtnLogin:
                dialog.setMessage("正在登录，请稍后……");
                dialog.show();
                final BmobUser user = new AccountUser();
                user.setUsername(username);
                user.setPassword(password);
                user.login(mContext, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        dialog.dismiss();
                        Log.i("Biaobai", "Login is Success!!");
                        Toast.makeText(LoginActivity.this, "欢迎用户:" + user.getUsername().toString() + "登录!", Toast.LENGTH_SHORT).show();
                        I2GO.Go2MainActivity((Activity) mContext);
                        ((Activity) mContext).finish();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        dialog.dismiss();
                        Toast.makeText(LoginActivity.this, i + s, Toast.LENGTH_SHORT).show();
                        Log.i("Biaobai", "i=" + i + "s=" + s);
                    }
                });
                break;
            case R.id.logBtnReg:
                dialog.setMessage("正在跳转……");
                dialog.show();
                I2GO.Go2RegistActivity((Activity) mContext);
                dialog.dismiss();
                break;
        }
    }
}
