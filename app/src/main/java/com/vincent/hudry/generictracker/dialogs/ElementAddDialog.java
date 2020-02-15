package com.vincent.hudry.generictracker.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.Form;
import com.vincent.hudry.generictracker.model.form.FormElements.Int_Data;

public class ElementAddDialog {
    public AlertDialog that;

    private String[] titles = new String[]{"int"};

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
                    /*
                    case "label":
                        LabelElement labelElement = new LabelElement(activity);
                        form.addElement(labelElement);
                        labelElement.setLabel("dummy text");
                        break;
                    case "AutoDate":
                        AutoDateElement autoDateElement = new AutoDateElement(activity);
                        form.addElement(autoDateElement);
                        break;
                    */
                    case "int":
                        Int_Data int_data = new Int_Data(activity);
                        Form currentForm = Globals.currentForm;
                        currentForm.displayModel.elements.add(int_data);
                        currentForm.dataModel.elements.add(int_data);
                        currentForm.displayModel.generateLayout();
                        break;
                    default:
                        break;
                }
            }
        }).setNegativeButton(R.string.cancel, null);

        that = builder.create();
    }
}
