package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.instrument_app.Instrument.getInstrumentsList;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvSearchResults;
    static String category;
    ListView listView;
    InstrumentAdapter instrumentAdapter;

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

        MainActivity.this.setTitle("Instrument App");
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
                //InstrumentProvider.generateAllInstruments();
                for (int i = 0; i < 50; i++) {
                    String brand = getInstrumentsList().get(i).getBrand();
                    if (brand.equalsIgnoreCase(query)) {
                        SearchArray.add(getInstrumentsList().get(i));
                    }
                }




                setContentView(R.layout.activity_list);
                tvSearchResults = findViewById(R.id.tvSearchResults);

                listView = (ListView) findViewById(R.id.listView);
                instrumentAdapter = new InstrumentAdapter(MainActivity.this,
                        SearchArray);
                listView.setAdapter(instrumentAdapter);
                LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
                setupSelectedInstrumentListener();

                // Set activity title to search query
                MainActivity.this.setTitle(query);
                if (SearchArray.size()==0) {
                    tvSearchResults.setText("Sorry, we found no results for: "+ "\""+query+"\"");
                }else{
                    tvSearchResults.setText(" ");
                }

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
        MainActivity.this.setTitle("Instrument App");
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
                putExtra(Intent.EXTRA_TEXT,"acoustic guitars");
        category = "acoustic guitars";

        startActivity(listActivity);
    }

    public void ShowElectricGuitars(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
            putExtra(Intent.EXTRA_TEXT,"electric guitars");
        category = "electric guitars";
        startActivity(listActivity);
    }

    public void ShowPianos(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"pianos");
        category = "pianos";
        startActivity(listActivity);
    }

    public void ShowUkuleles(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"ukuleles");
        category = "ukuleles";
        startActivity(listActivity);
    }

    public void ShowDrums(View view) {
        Intent listActivity = new Intent(this, ListActivity.class).
                putExtra(Intent.EXTRA_TEXT,"drums");
        category = "drums";
        startActivity(listActivity);
    }
}