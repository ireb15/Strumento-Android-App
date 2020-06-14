package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

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

import static com.example.instrument_app.Instrument.getInstrumentsList;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TopPicksAdapter.OnTopPickListener {
    private TextView tvSearchResults;
    static String category;
    ListView listView;
    InstrumentAdapter instrumentAdapter;
    private static ArrayList<Instrument> topPicks;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter topPicksAdapter;

    //Creates the Main Activity and determines which category has been clicked on
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWindowAnimations();
        InstrumentProvider.generateAllInstruments();

        // Initialise the RecyclerView for the "Top Picks" section
        recyclerView = (RecyclerView) findViewById(R.id.rvTopPicks);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        topPicks = Instrument.getTopPicks();
        topPicksAdapter = new TopPicksAdapter(this, topPicks, this);
        recyclerView.setAdapter(topPicksAdapter);

        MainActivity.this.setTitle("Strumento");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void updateTopPicks() {
        topPicksAdapter.notifyDataSetChanged();
    }

    private void setupWindowAnimations() {
        Slide slide = new Slide();
        slide.setDuration(5000);
        getWindow().setExitTransition(slide);

        Slide slide2 = new Slide();
        slide.setDuration(5000);
        getWindow().setReenterTransition(slide2);
    }

    //Registers when a particular instrument is selected
    public void setupSelectedInstrumentListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(category, instrumentAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instrument_list, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();


                ArrayList<Instrument> SearchArray = new ArrayList<>();
                //Go through all instruments and check if the query applies to any of them
                for (int i = 0; i < 50; i++) {
                    String brand = getInstrumentsList().get(i).getBrand();
                    String colour = getInstrumentsList().get(i).getColour();
                    String location = getInstrumentsList().get(i).getLocation();
                    String seller = getInstrumentsList().get(i).getSeller();
                    if ((brand.equalsIgnoreCase(query)) || (colour.equalsIgnoreCase(query)) ||
                            (location.equalsIgnoreCase(query))||(seller.equalsIgnoreCase(query))){
                        SearchArray.add(getInstrumentsList().get(i));
                    }
                }

                setContentView(R.layout.activity_list);
                tvSearchResults = findViewById(R.id.tvSearchResults);

                listView = (ListView) findViewById(R.id.listView);
                instrumentAdapter = new InstrumentAdapter(MainActivity.this,
                        SearchArray);
                listView.setAdapter(instrumentAdapter);
                // Set activity title to search query
                MainActivity.this.setTitle(query);
                if (SearchArray.size()==0) {
                    tvSearchResults.setText("Sorry, we found no results for: "+ "\""+query+"\"");
                }else{
                    tvSearchResults.setText("Results for: " + "\""+query+"\"");
                }

                LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
                setupSelectedInstrumentListener();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public void onBackPressed() {
        setContentView(R.layout.activity_main);
        MainActivity.this.setTitle("Strumento");
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
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"Acoustic Guitars");
        category = "Acoustic Guitars";
        startActivity(listActivity);
    }

    public void ShowElectricGuitars(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
            putExtra(Intent.EXTRA_TEXT,"Electric Guitars");
        category = "Electric Guitars";
        startActivity(listActivity);
    }

    public void ShowPianos(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"Pianos");
        category = "Pianos";
        startActivity(listActivity);
    }

    public void ShowUkuleles(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"Ukuleles");
        category = "Ukuleles";
        startActivity(listActivity);
    }

    public void ShowDrums(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"Drums");
        category = "Drums";
        startActivity(listActivity);
    }

    @Override
    public void onTopPickClick(int position) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class)
                .putExtra("Top Pick", topPicks.get(position));
        startActivity(intent);
    }
}