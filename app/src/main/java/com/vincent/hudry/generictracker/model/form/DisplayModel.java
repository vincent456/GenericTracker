package com.vincent.hudry.generictracker.model.form;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.json.JSONArray;

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

    }

    public DisplayModelElement fromID(String id) {
        for (DisplayModelElement dme : elements) {
            if (dme.)
        }
        return null;
    }
}
