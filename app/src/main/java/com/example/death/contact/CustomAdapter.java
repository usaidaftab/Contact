package com.example.death.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Death on 10/2/2017.
 */

public class CustomAdapter extends ArrayAdapter<user> {




        class ViewHolder{
            TextView name;
            TextView number;
        }
    CustomAdapter(Context context, List arrayList){
            super(context, 0,arrayList);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            user u= (user) getItem(position);
            ViewHolder vh;
            View view=convertView;
            if (view == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.lists, parent, false);
                TextView name=(TextView) view.findViewById(R.id.name);
                TextView number=(TextView) view.findViewById(R.id.number);
                vh=new ViewHolder();
                vh.name=name;
                vh.number=number;
                view.setTag(vh);
            }
            else
            {
                vh=(ViewHolder) view.getTag();
            }
            vh.name.setText(u.name);
            vh.number.setText(u.number);

            return view;
    }
}
