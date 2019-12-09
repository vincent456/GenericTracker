package com.vincent.hudry.generictracker.model.form.formElements;

import android.app.Activity;

public class Label extends FormElement {
    private String label;

    public Label(Activity activity) {
        super(activity);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
