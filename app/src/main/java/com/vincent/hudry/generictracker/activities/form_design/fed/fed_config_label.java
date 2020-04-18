package com.vincent.hudry.generictracker.activities.form_design.fed;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.dialogs.Fe_deleteDialog;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.FormElements.Label;

public class fed_config_label extends AppCompatActivity {

    private Label label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fed_config_label);
        this.label = (Label) Globals.currentFormElement;
        Button okay = findViewById(R.id.button5);
        Button delete = findViewById(R.id.button6);
        //TODO continue there

        //set fields
        ((EditText) findViewById(R.id.editText2)).setText(label.getDisplayID());
        ((EditText) findViewById(R.id.editText3)).setText(label.getLabel());
        //endregion

        final Activity that = this;
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fe_deleteDialog fe_deleteDialog = new Fe_deleteDialog(that);
                fe_deleteDialog.that.show();
            }
        });
        final Label label1 = label;
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = ((EditText) that.findViewById(R.id.editText2)).getText().toString();
                String labelText = ((EditText) that.findViewById(R.id.editText3)).getText().toString();
                label1.setID(ID);
                label1.setLabel(labelText);
                that.finish();
            }
        });
    }
}
