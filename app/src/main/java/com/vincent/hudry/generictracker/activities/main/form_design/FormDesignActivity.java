package com.vincent.hudry.generictracker.activities.main.form_design;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.dialogs.ElementAddDialog;
import com.vincent.hudry.generictracker.model.Globals;

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
}
