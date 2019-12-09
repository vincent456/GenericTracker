package com.vincent.hudry.generictracker.model.form.formElements;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.vincent.hudry.generictracker.R;

public class Label extends FormElement {
    private String label;
    private ImageButton control;

    public Label(Activity activity) {
        super(activity);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.fe_d_label, null);
        control = v.findViewById(R.id.control);
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        super.layout = v;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
