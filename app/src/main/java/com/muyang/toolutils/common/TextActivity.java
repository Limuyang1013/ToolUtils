package com.muyang.toolutils.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.muyang.toolutils.R;

/**
 * Created by Administrator on 2017/1/3.
 */

public class TextActivity extends AppCompatActivity implements View.OnClickListener{
    private Button text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= (Button) findViewById(R.id.btn_read);
        text.setOnClickListener(this);
        LogUtils.d("测试数据");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_read:
                break;
        }
    }
}
