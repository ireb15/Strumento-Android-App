package com.example.instrument_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;

// Sets up the display of an instrument's attributes
public class DetailActivity extends AppCompatActivity {

    private ImageView ivInstrumentCover1;
    private ImageView ivInstrumentCover2;
    private ImageView ivInstrumentCover3;
    private TextView tvTitle;
    private TextView tvPrice;
    private TextView tvSeller;
    private TextView tvDescription;
    private TextView tvLocation;
    private TextView tvColour;
    private static Instrument instrument;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivInstrumentCover1 = (ImageView) findViewById(R.id.ivInstrumentCover1);
        ivInstrumentCover2 = (ImageView) findViewById(R.id.ivInstrumentCover2);
        ivInstrumentCover3 = (ImageView) findViewById(R.id.ivInstrumentCover3);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvSeller = (TextView) findViewById(R.id.tvSeller);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvColour = (TextView) findViewById(R.id.tvColour);

        Intent intent = getIntent();
        instrument = (Instrument)
                intent.getSerializableExtra(ListActivity.INSTRUMENT_DETAIL_KEY);
        loadInstrument(instrument);
        this.setTitle("Strumento");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void updateViews() {
        // Increment the number of views of this instrument
        instrument.setViews();
        // Update the Top Pick for this category
        ArrayList<Instrument> categoryList = instrument.getCategoryList(instrument.getCategory());
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getViews() > instrument.getViews()) {
                instrument.updateTopPicks(instrument);
            }
        }
    }

    private void loadInstrument(Instrument instrument) {
        //change activity title
        this.setTitle(instrument.getTitle());
        tvTitle.setText(instrument.getTitle());
        tvPrice.setText("Price: $" + instrument.getPrice());
        tvDescription.setText("Description: " + instrument.getDescription() + ".");
        tvSeller.setText("Seller: " + instrument.getSeller());
        tvLocation.setText("Location: " + instrument.getLocation());
        tvColour.setText("Colour: " + instrument.getColour());
        int[] images = instrument.getImages();
        int resID1 = images[0];
        ivInstrumentCover1.setImageResource(resID1);
        int resID2 = images[1];
        ivInstrumentCover2.setImageResource(resID2);
        int resID3 = images[2];
        ivInstrumentCover3.setImageResource(resID3); }

}
