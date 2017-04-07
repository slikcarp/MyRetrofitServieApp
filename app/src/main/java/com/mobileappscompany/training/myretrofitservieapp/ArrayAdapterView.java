package com.mobileappscompany.training.myretrofitservieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by User on 2/23/2017.
 */

public class ArrayAdapterView extends ArrayAdapter<GitHub> {

    private final Context context;
    private final List<GitHub> values;

    public ArrayAdapterView(Context context, int resource, List<GitHub> values) {
        super(context, resource, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ListItemView rowView = (ListItemView) inflater.inflate(R.layout.list_item, parent, false);

        rowView.setGitHub(values.get(position));

        return super.getView(position, convertView, parent);
    }
}
