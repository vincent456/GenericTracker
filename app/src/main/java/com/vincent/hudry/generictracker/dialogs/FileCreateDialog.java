package com.vincent.hudry.generictracker.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.activities.form_design.FormDesignActivity;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.Form;

public class FileCreateDialog {

    public AlertDialog that;

    public FileCreateDialog(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.dialog_file_create, null);
        that = builder.setTitle(R.string.enter_file_name)
                .setView(view)
                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Globals.currentForm = new Form(activity);
                        EditText et = view.findViewById(R.id.name);
                        String name = et.getText().toString();
                        Globals.currentForm.name = name;
                        Globals.forms.add(Globals.currentForm);
                        Intent intent = new Intent(activity, FormDesignActivity.class);
                        activity.startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //pass
                    }
                })
                .create();
    }
}
