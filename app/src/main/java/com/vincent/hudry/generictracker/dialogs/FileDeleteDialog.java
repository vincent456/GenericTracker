package com.vincent.hudry.generictracker.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.Globals;

import java.io.File;

public class FileDeleteDialog {
    public AlertDialog that;

    public FileDeleteDialog(final Activity activity) {
        //TODO: continue there
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.do_you_want_to_delete_this_form);
        builder.setNegativeButton(R.string.cancel, null);
        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String filename = Globals.currentForm.name;
                File path = activity.getFilesDir();

                File file = new File(path, filename + ".form.json");
                if (!file.delete()) {
                    throw new RuntimeException("error deleting file");
                }
                activity.finish();
            }
        });
        that = builder.create();
    }
}
