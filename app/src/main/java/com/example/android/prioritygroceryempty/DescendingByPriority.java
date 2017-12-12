package com.example.android.prioritygroceryempty;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by ben on 12/1/17.
 */

public class DescendingByPriority implements Comparator<Map.Entry<String,Integer>> {
    public int compare(final Map.Entry<String, Integer> l, final Map.Entry<String, Integer> r) {


        return l.getValue().compareTo(r.getValue());
    }
}
