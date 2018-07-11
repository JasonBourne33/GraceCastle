package com.example.administrator.gracecastle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.util.T;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "msg";
    @BindView(R.id.btn_sharePref)
    Button btnSharePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Button btnSharePref = findViewById(R.id.btn_sharePref);
//        btnSharePref.set
    }


    @OnClick(R.id.btn_sharePref)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn_sharePref:
                Intent intent = new Intent();
                intent.setClass(this,SharePrefActivity.class);
                startActivity(intent);
                T.showShort(this,"sharePref");
                break;
        }
    }
}
