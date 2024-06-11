package com.example.test_login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private ArrayList<String> mDataSet;

    public CustomAdapter(Context context, ArrayList<String> dataSet) {
        super(context, R.layout.list_item, dataSet);
        this.mContext = context;
        this.mDataSet = dataSet;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            listItem = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView itemText = listItem.findViewById(R.id.item_text);
        itemText.setText(mDataSet.get(position));

        return listItem;
    }
}
