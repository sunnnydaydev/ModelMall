package com.example.administrator.modelmall.ui.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.db.UserRegisterBean;
import com.example.administrator.modelmall.ui.customview.StatusBarUtils;
import com.example.administrator.modelmall.ui.customview.ToastUtils;
import com.example.administrator.modelmall.utils.RegularVerification;
import com.orhanobut.logger.Logger;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_email)
    public TextInputEditText mEmail;
    @BindView(R.id.tv_pwd)
    public TextInputEditText mPwd;

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_to_register)
    TextView tvToRegister;
    private String dbEmail;
    private String dbPwd;
    private String email;
    private String pwd;

    @Override
    public Object offerLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onBindView() {
        hideActionBar();
        StatusBarUtils.setWindowStatusBarColor(this,R.color.orange);
        getDataFromDB();

        btnLogin.setOnClickListener(this);
        tvToRegister.setOnClickListener(this);


    }

    /**
     * 核对登陆信息
     */
    private boolean checkUserInputData() {
        boolean isPass = true;
        email = mEmail.getText().toString();
        pwd = mPwd.getText().toString();

        if (email.isEmpty() || !RegularVerification.isEmail(email)) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        }
        if (pwd.isEmpty() || pwd.length() < 6) {
            mPwd.setError("请输入至少6位密码");
            isPass = false;
        }

        return isPass;
    }

    /**
     * 从数据库读信息
     */
    private void getDataFromDB() {
        List<UserRegisterBean> user = DataSupport.findAll(UserRegisterBean.class);
        if (user != null) {
            for (UserRegisterBean userInfo : user) {
                dbEmail = userInfo.getEmail();
                dbPwd = userInfo.getPwd();
            }

        }
    }

    @Override
    public void destory() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (checkUserInputData()) {
                    if (email.equals(dbEmail) && pwd.equals(dbPwd)) {
                        ToastUtils.showToast(this,"登陆成功",ToastUtils.LENGTH_LONG);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        ToastUtils.showToast(this,"账号或者密码有误",ToastUtils.LENGTH_LONG);
                    }
                }
                break;
            case R.id.tv_to_register:
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                break;
        }

    }
}
