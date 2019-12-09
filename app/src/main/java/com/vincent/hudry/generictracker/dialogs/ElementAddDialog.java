package com.vincent.hudry.generictracker.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.form.Form;

public class ElementAddDialog {
    public AlertDialog that;

    private String[] titles = new String[]{"label"};

    public ElementAddDialog(final Activity activity, final Form form) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.select_element_to_add);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_element_add, null);
        Spinner spinner = view.findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, titles));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s = titles[i];
                switch (s) {
                    case "label":
                        //TODO continue here
                        Toast.makeText(activity, "label", Toast.LENGTH_SHORT).show();
                        //form.addElement(new Label());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        builder.setView(view);

        that = builder.create();
    }
}
