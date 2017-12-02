package com.example.android.prioritygroceryempty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by ben on 12/1/17.
 */

public class GroceryAdapter extends ArrayAdapter<Map.Entry<String,Integer>> {

    public GroceryAdapter(Context context, ArrayList<Map.Entry<String,Integer>> groceryList){
        super(context,0, groceryList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Map.Entry<String,Integer> item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_grocery, parent, false);
        }

        TextView itemName = (TextView) convertView.findViewById(R.id.grocery_item_name);

        itemName.setText(item.getKey());

        return convertView;
    }

}
