package com.vincent.hudry.generictracker.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.form.Form;
import com.vincent.hudry.generictracker.model.form.formElements.Label;

public class ElementAddDialog {
    public AlertDialog that;

    private String[] titles = new String[]{"label"};

    public ElementAddDialog(Activity activity, final Form form) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.select_element_to_add);
        Spinner spinner = new Spinner(activity);
        spinner.setAdapter(new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, titles));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s = titles[i];
                switch (s) {
                    case "label":
                        form.addElement(new Label());
                    default:
                        throw new IllegalStateException();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
