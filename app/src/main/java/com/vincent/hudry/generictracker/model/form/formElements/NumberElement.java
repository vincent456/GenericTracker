package com.vincent.hudry.generictracker.model.form.formElements;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import com.vincent.hudry.generictracker.R;

import org.json.JSONObject;

public class NumberElement extends FormElement {
    private View view;
    public NumberElement(Activity activity) {
        super(activity);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.fed_number, null);
        this.layout = view;
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
