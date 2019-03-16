package com.example.administrator.modelmall.ui.activities;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.utils.RegularVerification;

import butterknife.BindView;

public class SignUpActivity extends BaseActivity implements View.OnClickListener {
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

    @Override
    public Object offerLayout() {
        return R.layout.activity_sign_up;
    }


    @Override
    public void onBindView() {
        hideActionBar();
        btnRegister.setOnClickListener(this);
    }


    /**
     * 用户信息校验
     */
    private boolean checkInfo() {
        // 获得用户输入信息
        String name = userName.getText().toString();
        String email = userEmail.getText().toString();
        String phoneNumber = userPhoneNumber.getText().toString();
        String pwd = userPwd.getText().toString();
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
        if ( checkInfo()){
            Toast.makeText(this, "开始注册", Toast.LENGTH_SHORT).show();
            // todo 数据提交数据库 （实际是提交网络）
        }

    }
    @Override
    public void destory() {

    }
}
