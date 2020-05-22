package com.vincent.hudry.generictracker.model.form;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.recorder.DataModel;
import com.vincent.hudry.generictracker.model.recorder.DataModelElement;
import com.vincent.hudry.generictracker.model.recorder.DataModelElementFactory;

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

    public void generateDataModel(Activity activity) {
        try {
            JSONArray displayModel = this.jsonform.getJSONArray("displaymodel");
            for (int i = 0; i < displayModel.length(); i++) {
                JSONObject o = displayModel.getJSONObject(i);
                Log.d("str", o.toString());
                switch (o.getString("type")) {
                    case "label":
                        DataModel dm = Globals.currentForm.dataModel;
                        DataModelElement dme = DataModelElementFactory.instanciate(DataModelElementFactory.Elements.LABEL, activity);
                        dme.fromJSON(o);
                        dm.addElement(dme);
                        break;
                    case "int":
                        dm = Globals.currentForm.dataModel;
                        dme = DataModelElementFactory.instanciate(DataModelElementFactory.Elements.INT_Data, activity);
                        dme.fromJSON(o);
                        dm.addElement(dme);
                        break;
                    default:
                        break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
