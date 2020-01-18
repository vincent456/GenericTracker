package com.vincent.hudry.generictracker.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.formElements.LabelElement;

public class FED_label_Design_Activity extends AppCompatActivity {


    public LabelElement labelElement;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fed_label_design);
        assert (Globals.currentFormElement != null);
        labelElement = (LabelElement) Globals.currentFormElement;
        et = findViewById(R.id.editText3);
        et.setText(labelElement.getLabel());
    }

    public void onClick(View view) {
        labelElement.setLabel(et.getText().toString());
        finish();
    }

    public void delete(View view) {
        Globals.currentForm.removeElement(labelElement);
        finish();
    }
}
