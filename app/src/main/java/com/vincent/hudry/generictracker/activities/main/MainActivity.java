package com.vincent.hudry.generictracker.activities.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.vincent.hudry.generictracker.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.viewPager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);
        TabAdapter tabAdapter=new TabAdapter(getSupportFragmentManager(),this);
        pager.setAdapter(tabAdapter);

    }
}
