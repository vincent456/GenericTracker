package com.vincent.hudry.generictracker.model.form.FormElements;

import android.content.Context;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.model.form.FormElement;

import org.json.JSONException;
import org.json.JSONObject;

public class Int_Data extends FormElement {

    public String ID;
    private View displayView;
    private View dataView;
    private Context context;

    public Int_Data(Context context) {
        this.context = context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        displayView = layoutInflater.inflate(R.layout.fe_di_int_data, null);
        EditText et = new EditText(context);
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        dataView = et;
    }

    @Override
    public View getDataView() {
        return dataView;
    }

    @Override
    public JSONObject serialize2() {
        //TODO : is it really necessary ? refactor later
        EditText et = (EditText) dataView;
        JSONObject o = new JSONObject();
        try {
            o.put("ID", ID);
            o.put("type", "int");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public void deserialize2(JSONObject jsonObject) {

    }

    @Override
    public View getDisplayView() {
        return displayView;
    }

    @Override
    public JSONObject serialize() {
        JSONObject o = new JSONObject();
        try {
            o.put("type", "int");
            o.put("ID", ID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public void deserialize(JSONObject jsonObject) {

    }
}
