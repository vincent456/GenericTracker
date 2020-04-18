package com.vincent.hudry.generictracker.model.form.FormElements;

import android.app.Activity;

import com.vincent.hudry.generictracker.model.form.FormElement;

public class FormElementFactory {
    public static FormElement instanciate(Elements int_data, Activity activity) {
        switch (int_data) {
            case Int_Data:
                return new Int_Data(activity);
            case Label:
                return new Label(activity);
            default:
                throw new IllegalStateException();
        }
    }

    public enum Elements {Int_Data, Label}

}
