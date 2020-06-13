package com.vincent.hudry.generictracker.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVParser {

    private ArrayList<String> header = new ArrayList<>();
    private ArrayList<ArrayList<String>> data = new ArrayList<>();

    public void setHeader(ArrayList<String> header) {
        this.header = header;
    }

    public void appendData(ArrayList<String> data) throws Exception {
        if (!(data.size() == header.size())) {
            throw new Exception("header size and data size mismatch");
        }
        this.data.add(data);
    }

    public void parse(String s) throws Exception {
        String[] s1 = s.split("\\n");
        String h1 = s1[0];
        String[] h1array = h1.split(",");
        ArrayList<String> h1arraylist = new ArrayList<>(Arrays.asList(h1array));
        setHeader(h1arraylist);
        for (int i = 1; i < s1.length; i++) {
            String[] as = s1[i].split(",");
            ArrayList<String> asArraylist = new ArrayList<>(Arrays.asList(as));
            appendData(asArraylist);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < header.size() - 1; i++) {
            sb.append(header.get(i)).append(',');
        }
        sb.append(header.get(header.size() - 1)).append('\n');
        for (ArrayList<String> line : data) {
            for (int i = 0; i < line.size() - 1; i++) {
                sb.append(line.get(i)).append(',');
            }
            sb.append(line.get(line.size() - 1)).append('\n');
        }
        return sb.toString();
    }
}
