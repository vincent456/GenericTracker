package com.vincent.hudry.generictracker.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.Form;
import com.vincent.hudry.generictracker.model.form.FormElement;

public class Fe_deleteDialog {
    public AlertDialog that;

    public Fe_deleteDialog(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.do_you_want_to_delete_this_element)
                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Form currentform = Globals.currentForm;
                        FormElement currentFormElement = Globals.currentFormElement;
                        currentform.displayModel.elements.remove(currentFormElement);
                        activity.finish();
                    }
                })
                .setNegativeButton(R.string.cancel, null);

        that = builder.create();
    }
}
