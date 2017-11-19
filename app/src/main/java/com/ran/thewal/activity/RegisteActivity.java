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

import cn.bmob.v3.listener.SaveListener;
/**
 * @作者 Ranyiran
 * @介绍 注册界面的实现
 * @时间 2017/11/19 14:40
 *
 *       版本：
 *              1.先通过手机验证码后进入资料填写界面。
 *              2.直接用户名密码注册。进入界面后再进行资料的填写
 *              3.用户名，密码填写。验证手机号码。最后用手机号码进行登陆。
 *
 *
 */

public class RegisteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mEtUsername, mEtPassword;
    Button mBtnReg;
    String username, password;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        mContext = this;
        initView();
        setListener();
    }

    private void setListener() {
        mBtnReg.setOnClickListener(this);
    }

    /**
     * 绑定控件  初始化
     */
    private void initView() {
        mEtUsername = (EditText) this.findViewById(R.id.regEtUsername);
        mEtPassword = (EditText) this.findViewById(R.id.regEtPassword);
        mBtnReg = (Button) this.findViewById(R.id.regBtnReg);

    }


    @Override
    public void onClick(View v) {
        final ProgressDialog dialog = ProgressDialog.show(this, null, "正在注册，请稍后...");
        username = mEtUsername.getText().toString().trim();
        password = mEtPassword.getText().toString().trim();
        switch (v.getId()) {
            case R.id.regBtnReg:
                dialog.show();
                AccountUser accountUser = new AccountUser();
                accountUser.setUsername(username);
                accountUser.setPassword(password);
                accountUser.setEmail("271536025@qq.com");
                accountUser.setMobilePhoneNumber("13158093291");
                accountUser.setAge(20);
                accountUser.setSex("男");
                //判断注册是否成功
                accountUser.signUp(mContext, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        dialog.dismiss();
                        Toast.makeText(RegisteActivity.this, "注册成功正在跳转", Toast.LENGTH_SHORT).show();
                        I2GO.Go2LoginActivity((Activity) mContext);
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        dialog.dismiss();
                        switch (i) {
                            case 202:
                                Toast.makeText(RegisteActivity.this, "该用户名已经存在!", Toast.LENGTH_SHORT).show();
                                break;
                            case 203:
                                Toast.makeText(RegisteActivity.this, "该邮箱已注册!请直接登陆!", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        Log.i("BiaoBai", "i=" + i + " " + "s=" + s);
                    }
                });

                break;
        }
    }

}
