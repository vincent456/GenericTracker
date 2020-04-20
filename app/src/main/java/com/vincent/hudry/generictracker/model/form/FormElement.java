package com.vincent.hudry.generictracker.model.form;

import com.vincent.hudry.generictracker.model.Globals;

public abstract class FormElement implements DisplayModelElement {
    public void setActive() {
        Globals.currentFormElement = this;
    }

    public abstract void setID(String toString);
}
