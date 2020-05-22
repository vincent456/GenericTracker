package com.vincent.hudry.generictracker.model.recorder;

import android.view.View;

import org.json.JSONObject;

public interface DataModelElement {
    View getDataModelElementView();

    void fromJSON(JSONObject object);
}
