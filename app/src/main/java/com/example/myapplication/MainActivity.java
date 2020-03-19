package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String HEADING = "heading";
    final String BODY = "body";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(createAdapter());
    }

    @NonNull
    private BaseAdapter createAdapter() {
        return new SimpleAdapter(this, prepareContent(), R.layout.list_adapter_item, new String[]{"body", "heading"}, new int[]{R.id.heading, R.id.body});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> temp = new ArrayList<>();
        String[] values = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < values.length; i++) {
            Map<String, String> mapItem = new HashMap<>();
            mapItem.put(HEADING, String.valueOf(values[i].length()));
            mapItem.put(BODY, values[i]);
            temp.add(mapItem);
        }
        return temp;
    }
}