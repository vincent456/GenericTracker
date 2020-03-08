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
import com.vincent.hudry.generictracker.model.form.Form;
import com.vincent.hudry.generictracker.model.form.FormElement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FormDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_design);
        Intent intent = getIntent();
        /*
        if (Globals.currentForm == null && intent.hasExtra("file_name")) {
            //create form
            Globals.currentForm = new Form(this);
            File file = new File(intent.getStringExtra("file_name"));
            Globals.currentForm.name = file.getName().split("\\.")[0];
            Log.d("form name", Globals.currentForm.name);
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuilder stringBuilder = new StringBuilder();
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuilder.append(s);
                }
                s = stringBuilder.toString();
                JSONArray jsonArray = new JSONArray(s);
                Globals.currentForm.displayModel.fromJSON(jsonArray);
                //Globals.currentForm.fromJSON(jsonArray);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }

         */
        /*
        if (Globals.currentForm != null) {
            try {
                ((ViewGroup) Globals.currentForm.displayModel.view.getParent()).removeView(Globals.currentForm.displayModel.view);
            } catch (Exception e) {

            }
            ((FrameLayout) findViewById(R.id.FrameLayout)).addView(Globals.currentForm.displayModel.view);
        }
         */
    }

    public void add_item(View view) {
        ElementAddDialog elementAddDialog = new ElementAddDialog(this, Globals.currentForm);
        elementAddDialog.that.show();
        redraw();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        redraw();
    }

    void redraw() {
        FrameLayout frameLayout = findViewById(R.id.FrameLayout);
        try {
            ((ViewGroup) Globals.currentForm.displayModel.view.getParent()).removeView(Globals.currentForm.displayModel.view);
        } catch (Exception e) {

        }
        Globals.currentForm.displayModel.generateLayout();
        frameLayout.addView(Globals.currentForm.displayModel.view);
    }

    public void onClick(View view) {
        //check form
        /*
        if (!Globals.currentForm.check()) {
            //error
            return;
        }*

         */
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

    public void onDeleteClick(View view) {
        File path = getFilesDir();
        File directory = new File(path.getPath());
        File[] files = directory.listFiles();
        for (File file : files) {
            String target = Globals.currentForm.name + ".form.json";
            if (file.getName().equals(target)) {
                file.delete();
                finish();
            }
        }
        finish();
    }

    public void onUpClick(View view) {
        FormElement fe = Globals.currentFormElement;
        if (fe == null) {
            return;
        }
        Form f = Globals.currentForm;
        int index = f.displayModel.elements.indexOf(fe);
        f.displayModel.elements.remove(index);
        f.dataModel.elements.remove(index);
        index--;
        index = Math.max(index, 0);
        f.displayModel.elements.add(index, fe);
        f.dataModel.elements.add(index, fe);
        f.displayModel.generateLayout();
    }

    public void onDownClick(View view) {
        FormElement fe = Globals.currentFormElement;
        if (fe == null) {
            return;
        }
        Form f = Globals.currentForm;
        int index = f.displayModel.elements.indexOf(fe);
        f.displayModel.elements.remove(index);
        f.dataModel.elements.remove(index);
        index++;
        index = Math.min(f.displayModel.elements.size(), index);
        f.displayModel.elements.add(index, fe);
        f.dataModel.elements.add(index, fe);
        f.displayModel.generateLayout();
    }
}
