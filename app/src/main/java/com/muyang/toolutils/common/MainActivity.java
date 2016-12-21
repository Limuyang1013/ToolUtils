package com.muyang.toolutils.common;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.muyang.toolutils.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limuyang on 2016/12/21.
 */

public class MainActivity extends AppCompatActivity {
    private TextView show;
    private Button read;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView) findViewById(R.id.show_txt);
        read = (Button) findViewById(R.id.btn_read);

    }
}
