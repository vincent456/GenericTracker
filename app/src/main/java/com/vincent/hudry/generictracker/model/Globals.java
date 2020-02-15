package com.vincent.hudry.generictracker.model;

import com.vincent.hudry.generictracker.model.form.Form;
import com.vincent.hudry.generictracker.model.form.FormElement;

import java.util.ArrayList;

/**
 * everything global to the application
 */
public class Globals {
    public static ArrayList<Form> forms = new ArrayList<>();
    public static Form currentForm = null;
    public static FormElement currentFormElement = null;
}
