package com.vincent.hudry.generictracker.model.form;

import android.app.Activity;
import android.widget.LinearLayout;

import com.vincent.hudry.generictracker.model.form.formElements.FormElement;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * represent a form
 */
public class Form {
    private ArrayList<FormElement> elements = new ArrayList<>();
    private LinearLayout layout;
    private Activity activity;

    public Form(Activity activity) {
        this.activity = activity;
        layout = new LinearLayout(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.VERTICAL);
    }

    public void addElement(FormElement element) {
        elements.add(element);
        layout.addView(element.layout);
    }

    public void moveIndex(int from, int to) {
        FormElement element = elements.get(from);
        elements.remove(from);
        elements.add(to, element);
    }

    public void removeElement(int index) {
        elements.remove(index);
    }

    public LinearLayout getLayout() {
        return layout;
    }

    public JSONArray toJSON() {
        JSONArray array = new JSONArray();
        for (FormElement fe : elements) {
            JSONObject object = fe.toJSON();
            array.put(object);
        }
        return array;
    }

    public String toString() {
        return toJSON().toString();
    }

}
