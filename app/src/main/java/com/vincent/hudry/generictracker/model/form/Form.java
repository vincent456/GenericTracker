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
    public String name;

    public ArrayList<FormElement> getElements() {
        return elements;
    }

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

    public void removeElement(FormElement element) {
        elements.remove(element);
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

    public void regenerateLayout() {
        layout.removeAllViews();

        layout = new LinearLayout(activity);
        for (FormElement fe : elements) {
            fe.regenerateLayout();
            layout.addView(fe.layout);
        }
    }

    public void buildIDs() {
        int i = 1;
        for (FormElement fe : elements) {
            fe.id = i;
            i++;
        }
    }

    public FormElement getByID(int id) {
        for (FormElement fe : elements) {
            if (fe.id == id) {
                return fe;
            }
        }
        return null;
    }
}
