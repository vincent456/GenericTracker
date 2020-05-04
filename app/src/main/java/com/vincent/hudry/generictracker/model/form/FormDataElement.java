package com.vincent.hudry.generictracker.model.form;

import android.view.View;

import org.json.JSONObject;

public interface FormDataElement {
    View getDataView();

    void deserializeFDE(JSONObject object);
}
