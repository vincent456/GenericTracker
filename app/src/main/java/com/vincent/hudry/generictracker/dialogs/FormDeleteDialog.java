package com.vincent.hudry.generictracker.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.vincent.hudry.generictracker.R;

public class FormDeleteDialog {

    public AlertDialog that;

    public FormDeleteDialog(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.do_you_want_to_delete_this_form);
        builder.setNegativeButton(R.string.cancel, null);
        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                activity.finish();
            }
        });
        that = builder.create();
    }
}
