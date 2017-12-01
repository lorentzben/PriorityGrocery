package com.example.android.prioritygroceryempty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by ben on 12/1/17.
 */

public class GroceryAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private PriorityQueue<Map.Entry<String,Integer>> mDataSource;

    public GroceryAdapter(Context context, PriorityQueue<Map.Entry<String,Integer>> items){
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();

    }

    @Override
    public Object getItem(int i) {
        Map.Entry<String,Integer> temp = new AbstractMap.SimpleEntry<String, Integer>("no", 1);
        for(int j = 0; j == i; j++)
        {
            temp = mDataSource.peek();
        }
        return temp;
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.activity_main, parent,false);
        }


        //TextView text = (TextView)convertView.findViewById(R.id.grocery_list_view);


        Map.Entry<String,Integer> groceryItem = (Map.Entry<String,Integer>) getItem(i);
        //text.setText(groceryItem.getKey());

        return convertView;
    }
}
