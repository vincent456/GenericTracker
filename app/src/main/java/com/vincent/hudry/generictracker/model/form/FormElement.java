package com.vincent.hudry.generictracker.model.form;

import com.vincent.hudry.generictracker.model.Globals;

public abstract class FormElement implements DataModelElement, DisplayModelElement {
    public void setActive() {
        Globals.currentFormElement = this;
    }
}
