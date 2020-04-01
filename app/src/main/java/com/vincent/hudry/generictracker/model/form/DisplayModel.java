package com.vincent.hudry.generictracker.model.form;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vincent.hudry.generictracker.model.form.FormElements.FormElementFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisplayModel {
    public View view;
    public ArrayList<DisplayModelElement> elements = new ArrayList<>();
    /**
     * configure the way the form is displayed
     */
    private Context context;
    private LinearLayout layout;

    public DisplayModel(Context context) {
        this.context = context;
        layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        this.view = layout;
        generateLayout();
    }

    public void generateLayout() {
        layout.removeAllViews();
        for (DisplayModelElement e : elements) {
            layout.addView(e.getDisplayView());
        }
    }

    public void fromJSON(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject o = jsonArray.getJSONObject(i);
                String type = o.getString("type");
                switch (type) {
                    case "int":
                        FormElement fe = FormElementFactory.instanciate(FormElementFactory.Elements.Int_Data, (Activity) this.context);
                        fe.deserialize(o);
                        fe.deserialize2(o);
                        break;
                    default:
                        throw new IllegalStateException();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public DisplayModelElement fromID(String id) {
        for (DisplayModelElement dme : elements) {
            if (dme.getDisplayID().equals(id)) {
                return dme;
            }
        }
        return null;
    }
}
