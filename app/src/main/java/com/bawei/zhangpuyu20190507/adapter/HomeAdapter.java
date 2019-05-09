package com.bawei.zhangpuyu20190507.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.zhangpuyu20190507.base.BaseFragment;

import java.util.List;

public class HomeAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> list;
    private String[] titles = new String[]{"首页","我的"};

    public HomeAdapter(FragmentManager fm,List<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
