package com.vincent.hudry.generictracker.model.form.formDataElements;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.vincent.hudry.generictracker.model.form.FormDataElement;

import org.json.JSONObject;

public class LabelData implements FormDataElement {
    private Activity activity;

    private String label;

    public LabelData(Activity activity) {
        this.activity = activity;
    }

    @Override
    public View getDataView() {
        TextView tv = new TextView(activity);
        tv.setText(label);
        return tv;
    }

    @Override
    public void deserializeFDE(JSONObject object) {
        Log.d("obj", object.toString());
    }

}
