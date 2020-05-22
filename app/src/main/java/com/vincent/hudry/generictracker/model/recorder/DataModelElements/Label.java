package com.vincent.hudry.generictracker.model.recorder.DataModelElements;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.vincent.hudry.generictracker.model.recorder.DataModelElement;

import org.json.JSONException;
import org.json.JSONObject;

public class Label implements DataModelElement {

    private View view;
    private Activity activity;

    private String label;
    private String ID;

    public Label(Activity activity) {
        this.activity = activity;
        this.view = new TextView(activity);
    }

    @Override
    public View getDataModelElementView() {
        TextView tv = (TextView) this.view;
        tv.setText(this.label);
        return this.view;
    }

    @Override
    public void fromJSON(JSONObject object) {
        Log.d("label data object", object.toString());
        try {
            this.ID = object.getString("ID");
            this.label = object.getString("label");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("break", "break");
    }
}
