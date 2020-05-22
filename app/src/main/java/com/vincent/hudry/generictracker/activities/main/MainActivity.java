package com.vincent.hudry.generictracker.activities.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.vincent.hudry.generictracker.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private int activeTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.viewPager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);
        TabAdapter tabAdapter=new TabAdapter(getSupportFragmentManager(),this);
        pager.setAdapter(tabAdapter);
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                activeTab = tab.getPosition();
            }
        });
    }

    public int getActiveTab() {
        return activeTab;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        fillDesignTab();
    }

    public void fillDesignTab() {
        //TODO response depends on active tab
        File path = getFilesDir();
        File directory = new File(path.getPath());
        File[] files = directory.listFiles();
        //if in design mode
        RecyclerView rw = findViewById(R.id.recyclerView);
        RWAdapter adapter = new RWAdapter(files);
        rw.setAdapter(adapter);
        //if in record mode
        RecyclerView rw2 = findViewById(R.id.recyclerview2);
        RWAdapter2 adapter2 = new RWAdapter2(files);
        rw2.setAdapter(adapter2);
    }
}
