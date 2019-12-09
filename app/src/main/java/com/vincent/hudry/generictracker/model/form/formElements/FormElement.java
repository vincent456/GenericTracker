package com.vincent.hudry.generictracker.model.form.formElements;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.vincent.hudry.generictracker.R;

public class FormElement {
    private Activity activity;

    public View layout;
    public FormElement(Activity activity) {
        this.activity = activity;

        View v = activity.getLayoutInflater().inflate(R.layout.layout_form_element, null);
        FrameLayout up = v.findViewById(R.id.up);
        FrameLayout down = v.findViewById(R.id.down);
        up.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
        down.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
    }
}
