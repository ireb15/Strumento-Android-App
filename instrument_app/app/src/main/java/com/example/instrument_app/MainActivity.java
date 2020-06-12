package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView acousticGuitars = (CardView)findViewById(R.id.AcousticGuitarCategory);
        acousticGuitars.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Operations to perform when the view is clicked
                Intent acousticGuitars = new Intent(getBaseContext(), ListActivity.class);
                startActivity(acousticGuitars);
            }
        });
    }
}