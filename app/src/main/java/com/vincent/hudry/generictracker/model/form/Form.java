package com.vincent.hudry.generictracker.model.form;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Form {
    public String name;

    public DisplayModel displayModel;

    public Form(Context context) {
        this.displayModel = new DisplayModel(context);
    }

    public JSONObject toJSON() {
        JSONObject o = new JSONObject();
        JSONArray JdispMod = new JSONArray();
        try {
            o.put("displaymodel", JdispMod);
            for (DisplayModelElement dme : displayModel.elements) {
                JdispMod.put(dme.serialize());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return o;
    }

    public void fromJSON(JSONObject o) {
        try {
            JSONArray displayModel = o.getJSONArray("displaymodel");
            this.displayModel.fromJSON(displayModel);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return toJSON().toString();
    }
}
