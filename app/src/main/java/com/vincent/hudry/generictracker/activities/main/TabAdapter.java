package com.vincent.hudry.generictracker.activities.main;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.vincent.hudry.generictracker.Design_main;
import com.vincent.hudry.generictracker.R;

class TabAdapter extends FragmentStatePagerAdapter {

    private Fragment[] fragments;
    private Activity activity;

    public TabAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        this.activity=activity;
        fragments=new Fragment[]{new Design_main()};
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return new String[]{activity.getString(R.string.design),activity.getString(R.string.record),activity.getString(R.string.track)}[position];
    }
}
