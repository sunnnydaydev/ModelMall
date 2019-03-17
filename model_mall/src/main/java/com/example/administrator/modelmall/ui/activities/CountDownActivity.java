package com.example.administrator.modelmall.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.administrator.modelmall.Constant.ModelConstant;
import com.example.administrator.modelmall.R;
import com.example.administrator.modelmall.utils.ModelPreference;

import butterknife.BindView;

/**
 * Create by SunnyDay on 2019/03/15
 */
public class CountDownActivity extends BaseActivity {
    @BindView(R.id.tv_count_down)
    AppCompatTextView countDownText;
    private CountDownTimer timer;

    @Override
    public Object offerLayout() {
        return R.layout.activity_countdown;
    }

    @Override
    public void onBindView() {
        setNoTitleBarAndFullScreen();
        initCountDown();
    }


    /**
     * 倒计时逻辑处理
     */
    private void initCountDown() {
        // 避免内存泄漏
        if (!isFinishing()) {
            timer = new CountDownTimer(1000 * 11, 1000) {
                @SuppressLint("SetTextI18n")
                @Override
                public void onTick(long millisUntilFinished) {
                    countDownText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            checkToJump();
                        }
                    });
                    int time = (int) millisUntilFinished;
                    countDownText.setText(time / 1000 + " 跳过");
                }

                @Override
                public void onFinish() {
                    checkToJump();
                }
            }.start();
        }
    }

    /**
     * 首次进入引导页判断
     */
    private void checkToJump() {
        boolean isFirstin = ModelPreference.getBoolean(CountDownActivity.this, ModelConstant.FIRST_IN, true);
        if (isFirstin) {
            startActivity(new Intent(CountDownActivity.this, GuideActivity.class));
            ModelPreference.putBoolean(CountDownActivity.this, ModelConstant.FIRST_IN, false);
        } else {
            startActivity(new Intent(CountDownActivity.this, LoginActivity.class));
        }
        finish();
    }

    @Override
    public void destory() {
        // 避免内存泄漏
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
