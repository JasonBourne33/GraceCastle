package com.example.administrator.gracecastle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.chaos.util.SharedPreferencesUtil;
import com.chaos.util.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharePrefActivity extends AppCompatActivity {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.cb_remengerPwd)
    CheckBox cbRemengerPwd;
    private static final String TAG = "msg";
    boolean isRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_pref);
        ButterKnife.bind(this);

        isRemember = SharedPreferencesUtil.getBoolean(this, "remember_password");
//        if(isRemember){
            String account = SharedPreferencesUtil.getString(this,"account");
            String pwd = SharedPreferencesUtil.getString(this,"password");
            Log.d(TAG, "onCreate: account=== "+account);
            etAccount.setText(account);
            etPwd.setText(pwd);
//        }
        T.showShort(this,account+" account isRemember=== "+isRemember);
    }

    @OnClick({R.id.btn_rememberPwd,R.id.btn_restore})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_rememberPwd:
                String account = etAccount.getText().toString();
                String pwd = etPwd.getText().toString();
                Boolean isRemember = SharedPreferencesUtil.getBoolean(this, "remember_password");
                if(account.equals("qwe")&& pwd.equals("asd")){
                    if(cbRemengerPwd.isChecked()){
                        SharedPreferencesUtil.putBoolean(this,"remember_password",true);
                        SharedPreferencesUtil.putString(this,"account",account);
                        SharedPreferencesUtil.putString(this,"password",pwd);
                    }

                    T.showShort(this,"login success isRemember=== "+isRemember);
                }else {
                    T.showShort(this,"login fail isRemember=== "+isRemember);
                }

                break;
            case R.id.btn_restore:

                break;
        }
    }
}
