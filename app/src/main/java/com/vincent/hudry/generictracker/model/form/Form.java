package com.vincent.hudry.generictracker.model.form;

import android.content.Context;
import android.util.Log;

import com.vincent.hudry.generictracker.model.recorder.DataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Form {
    public String name;

    public DisplayModel displayModel;

    public DataModel dataModel;
    private JSONObject jsonform;

    public Form(Context context) {
        this.displayModel = new DisplayModel(context);
        this.dataModel = new DataModel();
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
            this.jsonform = o;
            JSONArray displayModel = o.getJSONArray("displaymodel");
            this.displayModel.fromJSON(displayModel);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return toJSON().toString();
    }

    public void generateDataModel() {
        try {
            JSONArray displayModel = this.jsonform.getJSONArray("displaymodel");
            for (int i = 0; i < displayModel.length(); i++) {
                JSONObject o = displayModel.getJSONObject(i);
                Log.d("type", o.getString("type"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
