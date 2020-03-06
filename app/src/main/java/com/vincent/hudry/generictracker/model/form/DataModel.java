package com.vincent.hudry.generictracker.model.form;

import org.json.JSONArray;

import java.util.ArrayList;

public class DataModel {
    /**
     * configure the way the data is treated
     */
    public ArrayList<DataModelElement> elements = new ArrayList<>();

    public void fromJSON(JSONArray jsonArray) {

    }

    public DataModelElement fromID(String id) {
        return null;
    }
}
