package com.vincent.hudry.generictracker.model.recorder;

import android.app.Activity;

import com.vincent.hudry.generictracker.model.recorder.DataModelElements.Int_Data;
import com.vincent.hudry.generictracker.model.recorder.DataModelElements.Label;

public class DataModelElementFactory {
    public static DataModelElement instanciate(DataModelElementFactory.Elements element, Activity activity) {
        switch (element) {
            case LABEL:
                return new Label(activity);
            case INT_Data:
                return new Int_Data(activity);
            default:
                return null;
        }
    }

    public enum Elements {INT_Data, LABEL}
}
