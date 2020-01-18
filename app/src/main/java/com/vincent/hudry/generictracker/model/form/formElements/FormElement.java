package com.vincent.hudry.generictracker.model.form.formElements;

import android.app.Activity;
import android.view.View;
import android.widget.RadioButton;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class FormElement {
    public String id;

    public View layout;
    public RadioButton radioButton;
    protected Activity activity;
    public FormElement(Activity activity) {
        this.activity = activity;
    }

    public abstract JSONObject toJSON();

    public String toString() {
        return toJSON().toString();
    }

    public abstract void fromJSON(JSONObject object);

    public void fromString(String string) {
        try {
            JSONObject object = new JSONObject(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public abstract void regenerateLayout();

    public abstract JSONObject write();
}
