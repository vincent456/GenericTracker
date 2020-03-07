package com.vincent.hudry.generictracker.model.form.FormElements;

import android.app.Activity;
import android.content.Intent;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.activities.form_design.fed.fed_config_int_data_activity;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.DisplayModelElement;
import com.vincent.hudry.generictracker.model.form.FormElement;

import org.json.JSONException;
import org.json.JSONObject;

public class Int_Data extends FormElement {

    private String ID;
    private View displayView;
    private View dataView;
    private Activity activity;

    public Int_Data(final Activity activity) {
        this.activity = activity;
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        //region setup displayView
        displayView = layoutInflater.inflate(R.layout.fe_di_int_data, null);
        ImageButton button = displayView.findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, fed_config_int_data_activity.class);
                activity.startActivityForResult(intent, 0);
            }
        });
        final RadioButton radioButton = displayView.findViewById(R.id.radioButton);
        final Int_Data that = this;
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.currentFormElement = that;
                for (DisplayModelElement dme : Globals.currentForm.displayModel.elements) {
                    View displayview = dme.getDisplayView();
                    RadioButton radioButton1 = displayview.findViewById(R.id.radioButton);
                    radioButton1.setChecked(false);
                }
                View displayview = that.getDisplayView();
                RadioButton radioButton1 = displayview.findViewById(R.id.radioButton);
                radioButton1.setChecked(true);
            }
        });
        //endregion
        //region setup dataview
        EditText et = new EditText(activity);
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        dataView = et;
        //endregion
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
    public String getID2() {
        return ID;
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
    public String getDisplayID() {
        return ID;
    }

    @Override
    public void deserialize(JSONObject jsonObject) {

    }
}
