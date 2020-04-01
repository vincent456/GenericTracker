package com.vincent.hudry.generictracker.model.form;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Form {
    public String name;

    public DataModel dataModel;
    public DisplayModel displayModel;

    public Form(Context context) {
        this.dataModel = new DataModel();
        this.displayModel = new DisplayModel(context);
    }

    public JSONObject toJSON() {
        JSONObject o = new JSONObject();
        JSONArray JdispMod = new JSONArray();
        JSONArray JdatMod = new JSONArray();
        try {
            o.put("displaymodel", JdispMod);
            for (DisplayModelElement dme : displayModel.elements) {
                JdispMod.put(dme.serialize());
            }
            o.put("datamodel", JdatMod);
            for (DataModelElement dme : dataModel.elements) {
                JdatMod.put(dme.serialize2());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return o;
    }

    public void fromJSON(JSONObject o) {
        try {
            JSONArray displayModel = o.getJSONArray("displaymodel");
            JSONArray datamodel = o.getJSONArray("datamodel");
            this.displayModel.fromJSON(displayModel);
            this.dataModel.fromJSON(datamodel);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return toJSON().toString();
    }
}
