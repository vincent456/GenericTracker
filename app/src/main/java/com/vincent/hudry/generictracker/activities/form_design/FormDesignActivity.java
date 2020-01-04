package com.vincent.hudry.generictracker.activities.form_design;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.dialogs.ElementAddDialog;
import com.vincent.hudry.generictracker.model.Globals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FormDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_design);
        try {
            ((ViewGroup) Globals.currentForm.getLayout().getParent()).removeView(Globals.currentForm.getLayout());
        } catch (Exception e) {

        }
        ((FrameLayout) findViewById(R.id.FrameLayout)).addView(Globals.currentForm.getLayout());
    }

    public void add_item(View view) {
        ElementAddDialog elementAddDialog = new ElementAddDialog(this, Globals.currentForm);
        elementAddDialog.that.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        redraw();
    }

    void redraw() {
        FrameLayout frameLayout = findViewById(R.id.FrameLayout);
        try {
            ((ViewGroup) Globals.currentForm.getLayout().getParent()).removeView(Globals.currentForm.getLayout());
        } catch (Exception e) {

        }
        Globals.currentForm.regenerateLayout();
        frameLayout.addView(Globals.currentForm.getLayout());
    }

    public void onClick(View view) {
        //save and exit;
        String fileName = Globals.currentForm.name;
        File path = getFilesDir();

        File file = new File(path, fileName + ".form.json");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(Globals.currentForm.toString().getBytes());
            fos.close();
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
