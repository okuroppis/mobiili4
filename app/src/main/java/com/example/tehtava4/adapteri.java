package com.example.tehtava4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import java.util.List;

public class adapteri extends ArrayAdapter<luokka> {


    private Context context;
    ArrayList<luokka> data;
    luokka luokka;



    public adapteri(@NonNull Context context, int resource, @NonNull List<luokka> objects) {
        super(context, resource, objects);
        this.context = context;
        this.data = (ArrayList<luokka>)objects;




    }

    public View getView( int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.layoutti,parent,false);
        LinearLayout linearLayout = (LinearLayout) v;

        TextView lista = v.findViewById(R.id.textView1);
        TextView lista2 = v.findViewById(R.id.textView2);
        lista.setText(data.get(position).getTitle());
        lista2.setText(data.get(position).getBody());



        return v;

    }
}
