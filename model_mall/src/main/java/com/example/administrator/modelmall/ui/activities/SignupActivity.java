package com.example.administrator.modelmall.ui.activities;


import android.content.Intent;

import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.db.UserRegisterBean;

import com.example.administrator.modelmall.ui.customview.StatusBarUtils;
import com.example.administrator.modelmall.ui.customview.ToastUtils;
import com.example.administrator.modelmall.utils.RegularVerification;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

import butterknife.BindView;

public class SignupActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_name)
    public TextInputEditText userName;
    @BindView(R.id.tv_email)
    public TextInputEditText userEmail;
    @BindView(R.id.tv_phone_number)
    public TextInputEditText userPhoneNumber;
    @BindView(R.id.tv_pwd)
    public TextInputEditText userPwd;
    @BindView(R.id.tv_confirm)
    public TextInputEditText userConfirm;

    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.tv_to_login)
    TextView toLogin;
    private String name;
    private String email;
    private String phoneNumber;
    private String pwd;

    @Override
    public Object offerLayout() {
        return R.layout.activity_sign_up;
    }


    @Override
    public void onBindView() {
         hideActionBar();
         StatusBarUtils.setWindowStatusBarColor(this,R.color.orange);
        btnRegister.setOnClickListener(this);
        toLogin.setOnClickListener(this);
    }


    /**
     * 用户信息校验
     */
    private boolean checkInfo() {
        // 获得用户输入信息
        name = userName.getText().toString();
        email = userEmail.getText().toString();
        phoneNumber = userPhoneNumber.getText().toString();
        pwd = userPwd.getText().toString();
        String confirm = userConfirm.getText().toString();

        boolean isPass = true; // 是否通过检测
        if (name.isEmpty()) {
            userName.setError("请输入姓名");
            isPass = false;
        }

        if (email.isEmpty() || !RegularVerification.isEmail(email)) {
            userEmail.setError("错误的邮箱格式");
            isPass = false;
        }

        if (phoneNumber.isEmpty() || !RegularVerification.isMobile(phoneNumber)) {
            userPhoneNumber.setError("错误的手机号");
            isPass = false;
        }

        if (pwd.isEmpty() || pwd.length() < 6) {
            userPwd.setError("请输入至少6位密码");
            isPass = false;
        }
        if (confirm.isEmpty() || !confirm.equals(pwd)) {
            userConfirm.setError("两次密码不一致");
            isPass = false;
        }

        return isPass;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                if (checkInfo() && isSetDataTodbSuccess()) {
                    ToastUtils.showToast(this,"注册成功",ToastUtils.LENGTH_LONG);
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                }
                break;
            case R.id.tv_to_login:
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                break;
        }


    }

    /**
     * 存数据是否成功
     */
    private boolean isSetDataTodbSuccess() {
        boolean isSuccess = false;
        String phone = null;
        List<UserRegisterBean> users = DataSupport.findAll(UserRegisterBean.class);
        if (users != null) {
            for (UserRegisterBean userInfo : users) {
                phone = userInfo.getPhone();
            }
        }
        // 数据判断
        if (phoneNumber.equals(phone)) {
            ToastUtils.showToast(this,"手机号已经注册",ToastUtils.LENGTH_LONG);

        } else {

            LitePal.getDatabase();
            UserRegisterBean user = new UserRegisterBean();
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phoneNumber);
            user.setPwd(pwd);
            user.save();
            isSuccess = true;
        }
        return isSuccess;
    }

    @Override
    public void destory() {

    }
}
