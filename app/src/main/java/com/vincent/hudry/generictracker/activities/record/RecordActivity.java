package com.vincent.hudry.generictracker.activities.record;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.Form;
import com.vincent.hudry.generictracker.model.recorder.DataModelElement;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        generateLayout();
    }

    private void generateLayout() {
        LinearLayout main = findViewById(R.id.main);
        Globals.currentForm = new Form(this);
        String s = "";
        try {
            FileReader fr = new FileReader(Globals.formFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            s = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Globals.currentForm.fromJSON(new JSONObject(s));
            Globals.currentForm.generateDataModel(this);
            Log.d("break", "break");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //region render
        main.removeAllViews();
        for (DataModelElement dme : Globals.currentForm.dataModel.getElements()) {
            main.addView(dme.getDataModelElementView());
        }
        Button b = new Button(this);
        b.setText(R.string.okay);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        main.addView(b);
        //endregion
    }

    private void create_or_check(String file) {
        File f = new File(file);
        String base = f.getName().split("\\.form\\.json")[0];
        File[] d = getFilesDir().listFiles();
        for (File f2 : d) {
            String fn = f2.getName();
            if (fn.contains("csv") && fn.contains(base)) {
                Globals.record = f2;
                Globals.formFile = f;
                return;
            }
        }
        //no file found
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
