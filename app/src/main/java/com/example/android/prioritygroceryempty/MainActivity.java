package com.example.android.prioritygroceryempty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {


    PriorityQueue<Map.Entry<String,Integer>> storage = new PriorityQueue<>(1, new DescendingByPriority());
    PriorityQueue<Map.Entry<String,Integer>> limbo = new PriorityQueue<>(1, new DescendingByPriority());
    Map<String,Double> prices = new HashMap<String, Double>();
    Double cost = 0.0;
    Double tempPrice = 0.0;
    DecimalFormat df = new DecimalFormat("$#.##");
    final String PRIORITY_QUEUE = "prioirtyQueue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ListView mListView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        storage.offer(new AbstractMap.SimpleEntry<String, Integer>("butter",Integer.valueOf(3)));
        storage.offer(new AbstractMap.SimpleEntry<String, Integer>("beer",Integer.valueOf(5)));
        storage.offer(new AbstractMap.SimpleEntry<String, Integer>("cheese",Integer.valueOf(1)));
        prices.put("butter",5.5);
        prices.put("cheese", 2.22);
        prices.put("beer",3.54);
        */

        refreshView();

    }


    public void removeItem(View view) {
        TextView tvCost = (TextView) findViewById(R.id.cost);

        if(storage.peek() != null){
            Map.Entry<String,Integer> temp = storage.poll();
            String item = temp.getKey();
            tempPrice = prices.get(item);
            cost = cost + tempPrice;
            tvCost.setText((df.format(cost).toString()));

        }
        else{
            tvCost.setText("$0.00");
        }


        refreshView();

    }

    public void addItem(View view) {
        EditText etName = (EditText)findViewById(R.id.itemName);
        EditText etPriority = (EditText)findViewById(R.id.itemPriority);
        EditText etPrice = (EditText)findViewById(R.id.itemPrice);

        String itemName = etName.getText().toString();
        String strInt = etPriority.getText().toString();
        Integer itemPriority;
        //Integer itemPriority = (Integer) Integer.parseInt(strInt);
        Double itemPrice; //= Double.parseDouble(etPrice.getText().toString());
        if(etName.getText().toString().equals(null)){
            itemName = "";

        }if (etPriority.getText().toString().equals(""))
        {
            itemPriority = 10;
        }else{
            itemPriority = (Integer) Integer.parseInt(strInt);
        }
        if (etPrice.getText().toString().equals(""))
        {
            itemPrice = 0.00;
        }
        else{
            itemPrice = Double.parseDouble(etPrice.getText().toString());
        }

        storage.offer(new AbstractMap.SimpleEntry<String, Integer>(itemName, itemPriority));
        prices.put(itemName,itemPrice);

        refreshView();

        etName.setText("");
        etPriority.setText("");
        etPrice.setText("");


    }

    public void refreshView(){
        ArrayList<Map.Entry<String,Integer>> storageArrList = new ArrayList<>(storage);
        GroceryAdapter adapter = new GroceryAdapter(this, storageArrList);

        ListView listView = (ListView) findViewById(R.id.grocery_list_view);
        listView.setAdapter(adapter);
    }

    @Override
    public void onPause(){
        super.onPause();

         limbo = storage;
    }

    @Override
    public void onResume(){
        super.onResume();
        if(limbo == null){

        }else{
            storage = limbo;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        limbo = storage;

    }


}
