package com.example.administrator.modelmall.ui.customview;


import android.app.ProgressDialog;
import android.content.Context;

/**
 * Create by SunnyDay on 2019/03/16
 */
public class LoadingDialog {
    private Context context;
    private ProgressDialog progressDialog;

    public LoadingDialog(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
    }

    public LoadingDialog setTitles(String title) {
        progressDialog.setTitle(title);
        return this;
    }
    public LoadingDialog setMsgs(String msg) {
        progressDialog.setMessage(msg);
        return this;
    }
    public LoadingDialog setCancelable(boolean isCancel) {
        progressDialog.setCancelable(isCancel);
        return this;
    }
    public LoadingDialog show() {
        progressDialog.show();
        return this;
    }
    public  LoadingDialog dismiss(){
     progressDialog.dismiss();
     return this;
    }
}
