package com.dev.chawki.alpha.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dev.chawki.alpha.R;
import com.dev.chawki.alpha.models.Signe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilyes on 6/14/17.
 */

public class SigneAdapter extends ArrayAdapter<Signe> {

    public SigneAdapter(@NonNull Context context, @NonNull ArrayList<Signe> signes) {
        super(context, 0, signes);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the item
        Signe signe = getItem(position);

        // Get the layout file as a view
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.signe_list_item, parent, false);

        // Get the views
        TextView signeNameTV = (TextView) convertView.findViewById(R.id.signe_name_tv);


        // Set the data into the views
        signeNameTV.setText(signe.getName());

        return convertView;
    }
}
