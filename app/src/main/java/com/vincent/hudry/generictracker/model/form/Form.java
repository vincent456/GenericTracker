package com.vincent.hudry.generictracker.model.form;

import android.app.Activity;
import android.widget.LinearLayout;

import com.vincent.hudry.generictracker.model.form.formElements.FormElement;
import com.vincent.hudry.generictracker.model.form.formElements.LabelElement;

import org.json.JSONArray;
import org.json.JSONException;
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
        this.layout = new LinearLayout(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.VERTICAL);
        regenerateLayout();
    }

    public void addElement(FormElement element) {
        elements.add(element);
        layout.addView(element.layout);
        regenerateLayout();
    }

    public void moveIndex(int from, int to) {
        FormElement element = elements.get(from);
        elements.remove(from);
        elements.add(to, element);
        regenerateLayout();
    }

    public void removeElement(FormElement element) {
        elements.remove(element);
        regenerateLayout();
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

    public void fromJSON(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject o = jsonArray.getJSONObject(i);
                String type = o.getString("type");
                switch (type) {
                    case "labelElement":
                        LabelElement l = new LabelElement(activity);
                        l.fromJSON(o);
                        this.addElement(l);
                        break;
                    default:
                        throw new IllegalStateException();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString() {
        return toJSON().toString();
    }

    public void regenerateLayout() {
        layout.removeAllViews();
        for (FormElement fe : elements) {
            fe.regenerateLayout();
            layout.addView(fe.layout);
        }
    }

    /*
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
    */
    JSONArray write() {
        JSONArray out = new JSONArray();
        for (FormElement fe : elements) {
            out.put(fe.write());
        }
        return out;
    }

    public boolean check() {
        //TODO : fill me
        return false;
    }
}
