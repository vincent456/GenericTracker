package com.vincent.hudry.generictracker.model.form.formElements;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.activities.FED_label_Design_Activity;
import com.vincent.hudry.generictracker.model.Globals;
import com.vincent.hudry.generictracker.model.form.Form;

import org.json.JSONException;
import org.json.JSONObject;

public class LabelElement extends FormElement {
    private String label;
    private ImageButton control;
    private View view;

    public LabelElement(final Activity activity) {
        super(activity);
        regenerateLayout();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        try {
            object.put("type", "labelElement");
            object.put("labelElement", label);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void fromJSON(JSONObject object) {
        String out;
        try {
            out = object.getString("labelElement");
            this.setLabel(out);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void regenerateLayout() {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.fe_d_label, null);
        control = view.findViewById(R.id.control);
        final LabelElement that = this;

        radioButton = view.findViewById(R.id.radioButton);
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, FED_label_Design_Activity.class);
                Globals.currentFormElement = that;
                radioButton.setChecked(true);
                activity.startActivityForResult(intent, 0);
            }
        });
        super.layout = view;
        Form parent = Globals.currentForm;

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    for (FormElement fe : Globals.currentForm.getElements()) {
                        RadioButton rb = fe.radioButton;
                        rb.setChecked(false);
                    }
                    compoundButton.setChecked(true);
                    Globals.currentFormElement = that;
                }
            }
        });

        TextView tv = view.findViewById(R.id.textView2);
        tv.setText(label);
    }

    @Override
    public JSONObject write() {
        return null;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        TextView tv = view.findViewById(R.id.textView2);
        tv.setText(label);
    }
}
