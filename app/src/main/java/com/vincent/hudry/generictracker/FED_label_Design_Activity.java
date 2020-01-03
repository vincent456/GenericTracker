package com.vincent.hudry.generictracker;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.formElements.Label;

public class FED_label_Design_Activity extends AppCompatActivity {


    public Label label;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fed_label_design);
        assert (Globals.currentFormElement != null);
        label = (Label) Globals.currentFormElement;
        et = findViewById(R.id.editText3);
        et.setText(label.getLabel());
    }

    public void onClick(View view) {
        label.setLabel(et.getText().toString());
        finish();
    }

    public void delete(View view) {
        Globals.currentForm.removeElement(label);
        finish();
    }
}
