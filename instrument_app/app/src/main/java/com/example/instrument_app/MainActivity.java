package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Creates the Main Activity and determines which category has been clicked on
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ShowAcousticGuitars(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"acoustic guitars");
        startActivity(listActivity);
    }

    public void ShowElectricGuitars(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
            putExtra(Intent.EXTRA_TEXT,"electric guitars");
        startActivity(listActivity);
    }

    public void ShowPianos(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"pianos");
        startActivity(listActivity);
    }

    public void ShowUkuleles(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"ukuleles");
        startActivity(listActivity);
    }

    public void ShowDrums(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"drums");
        startActivity(listActivity);
    }
}