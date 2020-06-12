package com.example.instrument_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstrumentDetailActivity extends AppCompatActivity {

    private ImageView ivAcousticGuitarCover;
    private TextView tvTitle;
    private TextView tvPrice;
    private TextView tvSeller;
    private TextView tvDescription;
    private TextView tvLocation;
    private TextView tvColour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_detail);
        ivAcousticGuitarCover = (ImageView) findViewById(R.id.ivAcousticGuitarCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvSeller = (TextView) findViewById(R.id.tvSeller);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvColour = (TextView) findViewById(R.id.tvColour);
        Intent thisIntent = getIntent();
        // Use the instrument to populate the data into our views
        AcousticGuitar acousticGuitar = (AcousticGuitar)
                thisIntent.getSerializableExtra(ListActivity.ACOUSTIC_GUITAR_DETAIL_KEY);
        loadAcousticGuitar(acousticGuitar);
    }
    private void loadAcousticGuitar(AcousticGuitar acousticGuitar) {
        //change activity title
        this.setTitle(acousticGuitar.getTitle());
        tvTitle.setText(acousticGuitar.getTitle());
        tvPrice.setText("Price: $" + acousticGuitar.getPrice());
        tvDescription.setText("Description: " + acousticGuitar.getDescription() + ".");
        tvSeller.setText("Seller: " + acousticGuitar.getSeller());
        tvLocation.setText("Location: " + acousticGuitar.getLocation());
        tvColour.setText("Colour: " + acousticGuitar.getColour());
        //String mDrawableName = book.getCover();
        //int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        int[] images = acousticGuitar.getImages();
        int resID = images[0];
        ivAcousticGuitarCover.setImageResource(resID); }

}
