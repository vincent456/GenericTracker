package com.vincent.hudry.generictracker.model.form.formElements;

import android.app.Activity;

import org.json.JSONObject;

public class NumberElement extends FormElement {
    public NumberElement(Activity activity) {
        super(activity);
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public void fromJSON(JSONObject object) {

    }

    @Override
    public void regenerateLayout() {

    }

    @Override
    public JSONObject write() {
        return null;
    }
}
