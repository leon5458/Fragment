package com.hly;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;

    /**
     * framelayout
     */
    @BindView(R.id.hp_bottom_layout)
    View hp_layout;
    @BindView(R.id.service_bottom_layout)
    View service_layout;
    @BindView(R.id.action_bottom_layout)
    View action_layout;
    @BindView(R.id.myself_bottom_layout)
    View myself_layout;

    /**
     * image
     *
     * @return
     */
    @BindView(R.id.hp_bottom_image)
    ImageView hpImage;
    @BindView(R.id.service_bottom_image)
    ImageView serviceImage;
    @BindView(R.id.action_bottom_image)
    ImageView actionImage;
    @BindView(R.id.myself_bottom_image)
    ImageView myselfImage;

    /**
     * text
     *
     * @return
     */
    @BindView(R.id.hp_bottom_text)
    TextView hpText;
    @BindView(R.id.service_bottom_text)
    TextView serviceText;
    @BindView(R.id.action_bottom_text)
    TextView actionText;
    @BindView(R.id.myself_bottom_text)
    TextView myselfText;

    private FragmentManager fragmentManager;//对fragment的管理


    /**
     * 防止错误发生会导致fragment重叠
     *
     * @param fragment
     */
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment1 == null && fragment instanceof Fragment1) {
            fragment1 = (Fragment1) fragment;
        } else if (fragment2 == null && fragment instanceof Fragment2) {
            fragment2 = (Fragment2) fragment;
        } else if (fragment3 == null && fragment instanceof Fragment3) {
            fragment3 = (Fragment3) fragment;
        } else if (fragment4 == null && fragment instanceof Fragment4) {
            fragment4 = (Fragment4) fragment;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);//第一次启动默认的tab(0)
    }


    @OnClick({R.id.hp_bottom_layout, R.id.service_bottom_layout, R.id.action_bottom_layout, R.id.myself_bottom_layout})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.hp_bottom_layout:
                setTabSelection(0);
                break;
            case R.id.service_bottom_layout:
                setTabSelection(1);
                break;
            case R.id.action_bottom_layout:
                setTabSelection(2);
                break;
            case R.id.myself_bottom_layout:
                setTabSelection(3);
                break;
        }
    }

    public void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        clearSelection();//每次选中之前清除掉上次选中的状态
        hideFragments(transaction);
        switch (index) {
            case 0:
                hpImage.setImageResource(R.mipmap.tab_contact_select);
                hpText.setTextColor(Color.parseColor("#293754"));
                hp_layout.setBackgroundColor(0xffDFE1E6);
                if (fragment1 == null) {
                    fragment1 = new Fragment1();
                    transaction.add(R.id.content, fragment1);
                } else {
                    transaction.show(fragment1);
                }
                break;
            case 1:
                serviceImage.setImageResource(R.mipmap.tab_home_select);
                serviceText.setTextColor(Color.parseColor("#293754"));
                service_layout.setBackgroundColor(0xffDFE1E6);
                if (fragment2 == null) {
                    fragment2 = new Fragment2();
                    transaction.add(R.id.content, fragment2);
                } else {
                    transaction.show(fragment2);
                }
                break;
            case 2:
                actionImage.setImageResource(R.mipmap.tab_more_select);
                actionText.setTextColor(Color.parseColor("#293754"));
                action_layout.setBackgroundColor(0xffDFE1E6);
                if (fragment3 == null) {
                    fragment3 = new Fragment3();
                    transaction.add(R.id.content, fragment3);
                } else {
                    transaction.show(fragment3);
                }
                break;

            case 3:
                myselfImage.setImageResource(R.mipmap.tab_speech_select);
                myselfText.setTextColor(Color.parseColor("#293754"));
                myself_layout.setBackgroundColor(0xffDFE1E6);
                if (fragment4 == null) {
                    fragment4 = new Fragment4();
                    transaction.add(R.id.content, fragment4);
                } else {
                    transaction.show(fragment4);
                }
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 清除所有选中的状态
     */
    private void clearSelection() {
        hpImage.setImageResource(R.mipmap.tab_contact_unselect);
        hpText.setTextColor(Color.parseColor("#82858b"));
        hp_layout.setBackgroundColor(0xffffffff);
        serviceImage.setImageResource(R.mipmap.tab_home_unselect);
        serviceText.setTextColor(Color.parseColor("#82858b"));
        service_layout.setBackgroundColor(0xffffffff);
        actionImage.setImageResource(R.mipmap.tab_more_unselect);
        actionText.setTextColor(Color.parseColor("#82858b"));
        action_layout.setBackgroundColor(0xffffffff);
        myselfImage.setImageResource(R.mipmap.tab_speech_unselect);
        myselfText.setTextColor(Color.parseColor("#82858b"));
        myself_layout.setBackgroundColor(0xffffffff);
    }

    /**
     * 将所有的Fragment设置隐藏状态,用于对Fragment执行操作的事务
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (fragment1 != null) {
            transaction.hide(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        }
        if (fragment3 != null) {
            transaction.hide(fragment3);
        }
        if (fragment4 != null) {
            transaction.hide(fragment4);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0X11) {
            setTabSelection(1);
        }
        if (resultCode == 0X12) {
            setTabSelection(2);
        }
        if (requestCode == 0x13) {
            setTabSelection(3);
        }

    }
}
