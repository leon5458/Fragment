package com.hly;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/6~~~~~~
 * ~~~~~~更改时间:2018/7/6~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class Assign2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assign2_activity_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fragment2_txt, R.id.fragment3_txt, R.id.fragment4_txt})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.fragment2_txt:
                setResult(0X11);
                finish();
                break;
            case R.id.fragment3_txt:
                setResult(0X12);
                finish();
                break;
            case R.id.fragment4_txt:
                setResult(0X13);
                finish();
                break;


        }
    }
}
