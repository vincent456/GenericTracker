package com.vincent.hudry.generictracker.model.recorder.DataModelElements;

import android.app.Activity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.vincent.hudry.generictracker.model.recorder.DataModelElement;

import org.json.JSONObject;

public class Int_Data implements DataModelElement {
    private View view;
    private Activity activity;

    private String ID;

    public Int_Data(Activity activity) {
        this.activity = activity;
        this.view = new EditText(activity);
        EditText editText = (EditText) this.view;
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Override
    public View getDataModelElementView() {
        return this.view;
    }

    @Override
    public void fromJSON(JSONObject object) {
        Log.d("json", object.toString());
        Log.d("break", "break");
    }
}
