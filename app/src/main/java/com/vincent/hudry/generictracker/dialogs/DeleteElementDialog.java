package com.vincent.hudry.generictracker.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.Form;
import com.vincent.hudry.generictracker.model.form.formElements.FormElement;

public class DeleteElementDialog {
    public AlertDialog that;
    public FormElement formElement;
    private View view;

    public DeleteElementDialog(final Activity activity, final Form form, FormElement formElement) {
        this.formElement = formElement;
        final FormElement FE = formElement;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.do_you_delete_element);
        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Globals.currentForm.removeElement(FE);
            }
        });
        builder.setNegativeButton(R.string.cancel, null);
        that = builder.create();
    }
}
