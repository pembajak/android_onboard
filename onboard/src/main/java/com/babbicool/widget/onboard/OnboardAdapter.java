package com.babbicool.widget.onboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OnboardAdapter extends FragmentStatePagerAdapter {

    List<OnboardPage> pages = new ArrayList<OnboardPage>();

    public OnboardAdapter(List<OnboardPage> pages, FragmentManager fm) {
        super(fm);
        this.pages = pages;
    }

    @Override
    public Fragment getItem(int position) {
        return OnboardFragment.newInstance(pages.get(position));
    }

    @Override
    public int getCount() {
        return pages.size();
    }


}
