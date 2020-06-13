package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter topPicksAdapter;

    //Creates the Main Activity and determines which category has been clicked on
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InstrumentProvider.generateAllInstruments();

        recyclerView = (RecyclerView) findViewById(R.id.rvTopPicks);
        // Improve performance since changes in content do not change the layout size of the
        // RecyclerView
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));

        //ArrayList<Instrument> topPicks = Instrument.getTopPicks();
        ArrayList<Instrument> topPicks = new ArrayList<Instrument>();
        topPicksAdapter = new TopPicksAdapter(this, topPicks);
        recyclerView.setAdapter(topPicksAdapter);

        int[] testImages = {R.drawable.bluthner_piano_1, R.drawable.bosendorfer_piano_1, R.drawable.british_drum_company_drums_1, R.drawable.c_bechstein_piano_1, R.drawable.canopus_drums_1};

        for (int i = 0; i < 5; i++) {
            int[] testImage = {testImages[i]};
            topPicks.add(new Instrument("Test"+i, 1, "Test", "Test",
                    "Test", "Test", "Test", "Test", 51+i, 0, testImage, "Acoustic Guitar"));
        }
        topPicksAdapter.notifyDataSetChanged();
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