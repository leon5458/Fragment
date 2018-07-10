package com.hly;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/7/6~~~~~~
 * ~~~~~~更改时间:2018/7/6~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.fragment2_txt, R.id.fragment3_txt, R.id.fragment4_txt, R.id.test_txt1})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.fragment2_txt:
                MainActivity main = (MainActivity) getActivity();
                main.setTabSelection(1);
                break;
            case R.id.fragment3_txt:
                MainActivity main1 = (MainActivity) getActivity();
                main1.setTabSelection(2);
                break;
            case R.id.fragment4_txt:
                MainActivity main2 = (MainActivity) getActivity();
                main2.setTabSelection(3);
                break;
            case R.id.test_txt1:
                Intent intent1 = new Intent(getActivity(), Assign2Activity.class);
                startActivityForResult(intent1, 0X11);
                break;

        }
    }
}
