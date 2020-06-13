package com.example.instrument_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivInstrumentCover;
    private TextView tvTitle;
    private TextView tvPrice;
    private TextView tvSeller;
    private TextView tvDescription;
    private TextView tvLocation;
    private TextView tvColour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivInstrumentCover = (ImageView) findViewById(R.id.ivInstrumentCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvSeller = (TextView) findViewById(R.id.tvSeller);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvColour = (TextView) findViewById(R.id.tvColour);

        Intent intent = getIntent();
        Instrument instrument = (Instrument)
                intent.getSerializableExtra(ListActivity.INSTRUMENT_DETAIL_KEY);
        loadInstrument(instrument);
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
        int resID = images[0];
        ivInstrumentCover.setImageResource(resID); }

}
