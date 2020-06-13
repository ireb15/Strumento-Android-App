package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

import static com.example.instrument_app.Instrument.getInstrumentsList;


public class MainActivity extends AppCompatActivity {

    static String category;
    ListView listView;
    InstrumentAdapter instrumentAdapter;

    //Creates the Main Activity and determines which category has been clicked on
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InstrumentProvider.generateAllInstruments();
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
                    if (brand.equalsIgnoreCase(query)){
                        SearchArray.add(getInstrumentsList().get(i));
                    }
                }
                setContentView(R.layout.activity_list);
                listView = (ListView) findViewById(R.id.listView);
                instrumentAdapter = new InstrumentAdapter(MainActivity.this,
                        SearchArray);
                listView.setAdapter(instrumentAdapter);
                LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
                setupSelectedInstrumentListener();

                // Set activity title to search query
                MainActivity.this.setTitle(query);
                return true;
            }

//            public void onBackPressed(){
//                setContentView(R.layout.activity_main);
//            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
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