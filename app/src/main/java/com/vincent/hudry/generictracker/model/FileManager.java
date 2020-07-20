package com.vincent.hudry.generictracker.model;

import android.content.Context;

import com.vincent.hudry.generictracker.model.form.Form;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    private static FileManager instance = new FileManager();
    private ArrayList<File> forms = new ArrayList<>();
    private Context context = null;

    private FileManager() {
    }

    public FileManager getInstance(Context context) {
        if (this.context == null) {
            this.context = context;
            //init
            File foldersDir = context.getFilesDir();
            for (File file : foldersDir.listFiles()) {
                this.forms.add(file);
            }
        }
        return instance;
    }

    public void addForm(Form form) {
        String fname = form.name;
        File foldersDir = context.getFilesDir();
        File fdir = new File(foldersDir.getAbsolutePath() + "/" + fname);
        fdir.mkdir();
        File json = new File(fdir.getAbsolutePath() + "/" + fname + ".json");
        File csv = new File(fdir.getAbsolutePath() + "/" + fname + ".csv");
        try {
            json.createNewFile();
            csv.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteForm(Form form) {
        String fname = form.name;
        File foldersDir = context.getFilesDir();
    }


}
