package com.vincent.hudry.generictracker.activities.record;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.Globals;

import java.io.File;
import java.io.IOException;

public class RecordActivity extends AppCompatActivity {

    //TODO continue there

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        String file = getIntent().getStringExtra("file_name");
        create_or_check(file);
        Log.d("fname", Globals.record.getAbsolutePath());
    }

    private void create_or_check(String file) {
        File f = new File(file);
        String base = f.getName().split("\\.form\\.json")[0];
        File[] d = getFilesDir().listFiles();
        for (File f2 : d) {
            String fn = f.getName();
            if (fn.matches("\\.csv") && fn.matches(base)) {
                Globals.record = f2;
                return;
            } else {
                //create
                File fd = new File(f.getAbsolutePath().split("\\.form\\.json")[0] + ".csv");
                try {
                    fd.createNewFile();
                    create_or_check(fd.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
