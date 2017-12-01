package com.example.android.prioritygroceryempty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView mListView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PriorityQueue<Map.Entry<String,Integer>> storage = new PriorityQueue<>(1, new DescendingByPriority());

        storage.offer(new AbstractMap.SimpleEntry<String, Integer>("butter",Integer.valueOf(3)));
        storage.offer(new AbstractMap.SimpleEntry<String, Integer>("beer",Integer.valueOf(5)));
        storage.offer(new AbstractMap.SimpleEntry<String, Integer>("cheese",Integer.valueOf(1)));
        
        //instantiate a listview
        mListView = (ListView) findViewById(R.id.grocery_list_view);


        GroceryAdapter adapter = new GroceryAdapter(this, storage);
        mListView.setAdapter(adapter);
    }
}