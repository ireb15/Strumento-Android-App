package com.example.instrument_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstrumentDetailActivity extends AppCompatActivity {

    private ImageView ivAcousticGuitarCover;
    private TextView tvTitle;
    private TextView tvDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_detail);
        ivAcousticGuitarCover = (ImageView) findViewById(R.id.ivAcousticGuitarCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        Intent thisIntent = getIntent();
        // Use the instrument to populate the data into our views
        AcousticGuitar acousticGuitar = (AcousticGuitar)
                thisIntent.getSerializableExtra(MainActivity.INSTRUMENT_DETAIL_KEY);
        loadAcousticGuitar(acousticGuitar);
    }
    private void loadAcousticGuitar(AcousticGuitar acousticGuitar) {
        //change activity title
        this.setTitle(acousticGuitar.getTitle());
        tvTitle.setText(acousticGuitar.getTitle());
        tvDescription.setText(acousticGuitar.getDescription());
        //String mDrawableName = book.getCover();
        //int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        int[] images = acousticGuitar.getImages();
        int resID = images[0];
        ivAcousticGuitarCover.setImageResource(resID); }

}
