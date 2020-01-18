package com.vincent.hudry.generictracker.model.form.formElements;

import android.app.Activity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.dialogs.DeleteElementDialog;
import com.vincent.hudry.generictracker.model.Globals;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class AutoDateElement extends FormElement {
    public AutoDateElement(Activity activity) {
        super(activity);
        regenerateLayout();
        this.id = "date";
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        try {
            object.put("type", "autodate");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public void fromJSON(JSONObject object) {

    }

    @Override
    public void regenerateLayout() {
        this.layout = activity.getLayoutInflater().inflate(R.layout.fed_autodate, null);
        TextView tv = this.layout.findViewById(R.id.textView3);
        tv.setText("AutoText");
        ImageButton control = this.layout.findViewById(R.id.control);
        final AutoDateElement that = this;
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteElementDialog deleteElementDialog = new DeleteElementDialog(activity, Globals.currentForm, that);
                deleteElementDialog.that.show();
                Globals.currentForm.regenerateLayout();
            }
        });
        this.radioButton = this.layout.findViewById(R.id.radioButton2);

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
    }

    @Override
    public JSONObject write() {
        JSONObject out = new JSONObject();
        try {
            out.put("id", this.id);
            out.put("type", "date");
            out.put("value", Calendar.getInstance().getTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return out;
    }

}
