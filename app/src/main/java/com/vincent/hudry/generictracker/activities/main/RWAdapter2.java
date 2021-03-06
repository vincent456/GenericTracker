package com.vincent.hudry.generictracker.activities.main;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vincent.hudry.generictracker.R;
import com.vincent.hudry.generictracker.activities.record.RecordActivity;
import com.vincent.hudry.generictracker.model.Globals;

import java.io.File;
import java.util.ArrayList;

public class RWAdapter2 extends RecyclerView.Adapter {

    private File[] files;

    public RWAdapter2(File[] files) {
        ArrayList<File> l = new ArrayList<>();
        for (File f : files) {
            if (f.getName().matches(".*\\.json")) {
                l.add(f);
            }
        }
        this.files = new File[l.size()];
        l.toArray(this.files);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_single_text, parent, false);
        RWVH2 rwvh = new RWVH2(view, (Activity) parent.getContext());
        return rwvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RWVH2 rwvh = (RWVH2) holder;
        rwvh.file = files[position];
        rwvh.tv.setText(files[position].getName());
    }

    @Override
    public int getItemCount() {
        return files != null ? files.length : 0;
    }
}

class RWVH2 extends RecyclerView.ViewHolder {

    private final Activity activity;
    public TextView tv;
    public File file;

    public RWVH2(@NonNull View itemView, final Activity activity) {
        super(itemView);
        this.tv = itemView.findViewById(R.id.textView);
        this.activity = activity;
        this.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.currentForm = null;
                Intent intent = new Intent(activity, RecordActivity.class);
                intent.putExtra("file_name", file.getPath());
                activity.startActivityForResult(intent, 0);
            }
        });
    }
}