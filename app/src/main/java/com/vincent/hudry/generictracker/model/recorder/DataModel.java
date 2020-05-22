package com.vincent.hudry.generictracker.model.recorder;

import java.util.ArrayList;

public class DataModel {
    private ArrayList<DataModelElement> elements = new ArrayList<>();

    public void addElement(DataModelElement element) {
        elements.add(element);
    }

    public ArrayList<DataModelElement> getElements() {
        return elements;
    }
}
