package com.vincent.hudry.generictracker.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.form.Form;
import com.vincent.hudry.generictracker.model.form.formElements.Label;

public class ElementAddDialog {
    public AlertDialog that;

    private String[] titles = new String[]{"label"};

    private View view;

    public ElementAddDialog(final Activity activity, final Form form) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.select_element_to_add);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.dialog_element_add, null);
        final Spinner spinner = view.findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, titles));

        builder.setView(view);

        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String s = titles[spinner.getSelectedItemPosition()];
                switch (s) {
                    case "label":
                        Label label = new Label(activity);
                        form.addElement(label);
                        label.setLabel("dummy text");
                        break;
                    default:
                        break;
                }
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        that = builder.create();
    }
}
