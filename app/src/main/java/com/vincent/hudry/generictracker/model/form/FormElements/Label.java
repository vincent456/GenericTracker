package com.vincent.hudry.generictracker.model.form.FormElements;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.activities.form_design.fed.fed_config_label;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.DisplayModelElement;
import com.vincent.hudry.generictracker.model.form.FormElement;

import org.json.JSONException;
import org.json.JSONObject;

public class Label extends FormElement {

    private String ID;
    private View displayView;
    private View dataView;
    private Activity activity;

    private String label;

    public Label(final Activity activity) {
        this.activity = activity;
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        //region setup displayView

        displayView = layoutInflater.inflate(R.layout.fe_di_label, null);
        ImageButton button = displayView.findViewById(R.id.imageButton2);
        final Label that = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentFormElement = that;
                Intent intent = new Intent(activity, fed_config_label.class);
                activity.startActivityForResult(intent, 0);
            }
        });

        final RadioButton radioButton = displayView.findViewById(R.id.radioButton);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentFormElement = that;
                for (DisplayModelElement dme : Globals.currentForm.displayModel.elements) {
                    View displayview = dme.getDisplayView();
                    RadioButton radioButton1 = displayview.findViewById(R.id.radioButton);
                    radioButton1.setChecked(false);
                }
                radioButton.setChecked(true);
            }
        });
        //endregion
        //region setup dataview
        dataView = null;
        //endregion
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
        TextView tv = displayView.findViewById(R.id.textView3);
        tv.setText(ID);

    }

    @Override
    public void setID(String toString) {
        this.ID = toString;
    }

    @Override
    public View getDisplayView() {
        return displayView;
    }

    @Override
    public JSONObject serialize() {
        JSONObject o = new JSONObject();
        try {
            o.put("type", "label");
            o.put("ID", ID);

            o.put("label", label);
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
        try {
            String ID = jsonObject.getString("ID");
            this.setID(ID);
            String label = jsonObject.getString("label");
            this.setLabel(label);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
