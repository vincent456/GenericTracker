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

public class fed_config_int_data_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fed_config_int_data_activity);
        Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editText);
        editText.setText(Globals.currentFormElement.getDisplayID());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.currentFormElement.setID(editText.getText().toString());
                finish();
            }
        });
        final Button delete = findViewById(R.id.button3);
        final Activity that = this;
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fe_deleteDialog deleteDialog = new Fe_deleteDialog(that);
                deleteDialog.that.show();
            }
        });
    }
}
