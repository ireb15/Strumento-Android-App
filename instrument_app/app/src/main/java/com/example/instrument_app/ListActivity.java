package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//Displays list view of the selected category of instruments and results from search
public class ListActivity extends AppCompatActivity {

    public static String INSTRUMENT_DETAIL_KEY = "acoustic guitar";
    ListView listView;
    InstrumentAdapter instrumentAdapter;
    static String category;
    private TextView tvSearchResults;

    //Determines and sets up the list view for the category chosen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);
        setupWindowAnimations();

        this.setTitle("Strumento");
        tvSearchResults = findViewById(R.id.tvSearchResults);
        listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        category = intent.getStringExtra(Intent.EXTRA_TEXT);
        INSTRUMENT_DETAIL_KEY = category;
        if (category.equals("Acoustic Guitars")) {
            ArrayList<Instrument> acousticGuitars = Instrument.getAcousticGuitarList();
            instrumentAdapter = new InstrumentAdapter(this, acousticGuitars);
            listView.setAdapter(instrumentAdapter);
        } else if (category.equals("Electric Guitars")) {
            ArrayList<Instrument> electricGuitars = Instrument.getElectricGuitarList();
            instrumentAdapter = new InstrumentAdapter(this, electricGuitars);
            listView.setAdapter(instrumentAdapter);
        } else if (category.equals("Pianos")) {
            ArrayList<Instrument> pianos = Instrument.getPianoList();
            instrumentAdapter = new InstrumentAdapter(this, pianos);
            listView.setAdapter(instrumentAdapter);
        } else if (category.equals("Ukuleles")) {
            ArrayList<Instrument> ukuleles = Instrument.getUkuleleList();
            instrumentAdapter = new InstrumentAdapter(this, ukuleles);
            listView.setAdapter(instrumentAdapter);
        } else {
            ArrayList<Instrument> drums = Instrument.getDrumsList();
            instrumentAdapter = new InstrumentAdapter(this, drums);
            listView.setAdapter(instrumentAdapter);
        }

        tvSearchResults.setText(category);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        setupSelectedInstrumentListener();

    }

    //Set up the Transitions
    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setEnterTransition(slide);

        Slide slide2 = new Slide();
        slide.setDuration(1000);
        getWindow().setReturnTransition(slide2);

    }

    //Registers when a particular instrument is selected
    public void setupSelectedInstrumentListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing the category as an extra
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra(INSTRUMENT_DETAIL_KEY, instrumentAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ShowAcousticGuitars(View view) {
    }

    public void ShowElectricGuitars(View view) {
    }

    public void ShowPianos(View view) {
    }

    public void ShowUkuleles(View view) {
    }

    public void ShowDrums(View view) {
    }
}

