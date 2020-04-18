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
import com.vincent.hudry.generictracker.model.form.FormElement;
import com.vincent.hudry.generictracker.model.form.FormElements.FormElementFactory;

public class ElementAddDialog {
    public AlertDialog that;

    private String[] titles = new String[]{"int", "label"};

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
                FormElementFactory.Elements fefe;
                if (s.equals("int"))
                    fefe = FormElementFactory.Elements.Int_Data;
                if (s.equals("label"))
                    fefe = FormElementFactory.Elements.Label;
                else
                    throw new IllegalStateException("no such element");

                FormElement fe = FormElementFactory.instanciate(fefe, activity);
                Form currentForm = Globals.currentForm;
                currentForm.displayModel.elements.add(fe);
                currentForm.dataModel.elements.add(fe);
                currentForm.displayModel.generateLayout();
                /*
                switch (s) {
                    case "int":
                        Int_Data int_data = new Int_Data(activity);
                        Form currentForm = Globals.currentForm;
                        currentForm.displayModel.elements.add(int_data);
                        currentForm.dataModel.elements.add(int_data);
                        currentForm.displayModel.generateLayout();
                        break;
                    case "label":
                        Label label = new Label()
                    default:
                        break;
                }
                 */
            }
        }).setNegativeButton(R.string.cancel, null);

        that = builder.create();
    }
}
