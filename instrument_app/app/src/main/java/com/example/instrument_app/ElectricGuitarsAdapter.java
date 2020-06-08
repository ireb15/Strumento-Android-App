package com.example.instrument_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instrument_app.AcousticGuitar;
import com.example.instrument_app.R;

import java.util.ArrayList;

public class ElectricGuitarsAdapter extends ArrayAdapter<ElectricGuitar> {

    private static class ViewHolder{
        public ImageView ivElectricGuitar;
        public TextView  tvTitle;
        public TextView tvDescription;
    }

    public ElectricGuitarsAdapter(Context context, ArrayList<ElectricGuitar> electricGuitars){
        super(context, 0, electricGuitars);
    }

    //translates a particular 'Book' given a position
    // into a relevant row within an AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the data item for this position
        final ElectricGuitar electricGuitar = getItem(position);
        //check if an existing view is being reused,
        // otherwise inflate the view

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_electric_guitar, parent, false);
            viewHolder.ivElectricGuitar = (ImageView) convertView.findViewById(R.id.ivElectricGuitarCover);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(electricGuitar.getTitle());
        viewHolder.tvDescription.setText(electricGuitar.getDescription());
        int[] images = electricGuitar.getImages();
        int resID = images[0];
        viewHolder.ivElectricGuitar.setImageResource(resID);
        return convertView;
    }
}