package com.aqpup.payme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import model.Person;

/**
 * Created by wilder on 26/06/15.
 */
public class DebtAdapter extends ArrayAdapter<Person> {

    public DebtAdapter(Context context, ArrayList<Person> persons){
        super(context, 0, persons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        Person person = getItem(position);

        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.row_debt, parent, false);
        }

        TextView tvName = (TextView)view.findViewById(R.id.tvName);
        TextView tvAmount = (TextView)view.findViewById(R.id.tvAmount);
        TextView tvDate = (TextView)view.findViewById(R.id.tvDate);

        tvName.setText(person.getName());
        tvAmount.setText(String.valueOf(person.getAmount()));
        tvDate.setText(String.valueOf(person.getDate()));


        return view;
    }
}
