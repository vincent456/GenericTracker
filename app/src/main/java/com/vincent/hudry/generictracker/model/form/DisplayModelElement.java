package com.vincent.hudry.generictracker.model.form;

import android.view.View;

import org.json.JSONObject;

public interface DisplayModelElement {
    View getDisplayView();

    JSONObject serialize();

    void deserialize(JSONObject jsonObject);
}
