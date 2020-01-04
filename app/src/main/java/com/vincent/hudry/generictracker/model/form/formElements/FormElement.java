package com.vincent.hudry.generictracker.model.form.formElements;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.vincent.hudry.generictracker.R;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class FormElement {
    public int id;

    public View layout;
    public RadioButton radioButton;
    protected Activity activity;
    public FormElement(Activity activity) {
        this.activity = activity;

        View v = activity.getLayoutInflater().inflate(R.layout.layout_form_element, null);
        FrameLayout up = v.findViewById(R.id.up);
        FrameLayout down = v.findViewById(R.id.down);
        up.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
        down.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
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
}
