package com.vincent.hudry.generictracker.activities.form_design.fed;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.vincent.hudry.generictracker.R;
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
    }
}
