package com.vincent.hudry.generictracker.model.form;

import android.view.View;

import org.json.JSONObject;

public interface DataModelElement {
    View getDataView();
    /**
     * equivalent to serialize but for datamodel
     */
    JSONObject serialize2();

    void deserialize2(JSONObject jsonObject);

    /**
     * equivalent to getID but for datamodel
     */
    String getID2();
}
