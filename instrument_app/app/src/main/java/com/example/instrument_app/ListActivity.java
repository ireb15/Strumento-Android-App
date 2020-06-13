package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    public static String INSTRUMENT_DETAIL_KEY = "acoustic guitar";

    ListView listView;
//    AcousticGuitarsAdapter acousticGuitarsAdapter;
//    ElectricGuitarsAdapter electricGuitarsAdapter;
//    PianosAdapter pianosAdapter;
//    UkulelesAdapter ukulelesAdapter;
//    DrumsAdapter drumsAdapter;

    InstrumentAdapter instrumentAdapter;

    static String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        category = intent.getStringExtra(Intent.EXTRA_TEXT);
        INSTRUMENT_DETAIL_KEY = category;
        if (category.equals("acoustic guitars")) {
            //ArrayList<AcousticGuitar> acousticGuitars = InstrumentProvider.generateAcousticGuitars();
            ArrayList<Instrument> acousticGuitars = InstrumentProvider.generateAcousticGuitars();
            //acousticGuitarsAdapter = new AcousticGuitarsAdapter(this, acousticGuitars);
            instrumentAdapter = new InstrumentAdapter(this, acousticGuitars);
            //listView.setAdapter(acousticGuitarsAdapter);
            listView.setAdapter(instrumentAdapter);
        } else if (category.equals("electric guitars")) {
            ArrayList<Instrument> electricGuitars = InstrumentProvider.generateElectricGuitars();
            instrumentAdapter = new InstrumentAdapter(this, electricGuitars);
            listView.setAdapter(instrumentAdapter);
        } else if (category.equals("pianos")) {
            ArrayList<Instrument> pianos = InstrumentProvider.generatePianos();
            instrumentAdapter = new InstrumentAdapter(this, pianos);
            listView.setAdapter(instrumentAdapter);
        } else if (category.equals("ukuleles")) {
            ArrayList<Instrument> ukuleles = InstrumentProvider.generateUkuleles();
            instrumentAdapter = new InstrumentAdapter(this, ukuleles);
            listView.setAdapter(instrumentAdapter);
        } else {
            ArrayList<Instrument> drums = InstrumentProvider.generateDrums();
            instrumentAdapter = new InstrumentAdapter(this, drums);
            listView.setAdapter(instrumentAdapter);
        }

        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupSelectedInstrumentListener();

    }


    public void setupSelectedInstrumentListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra(INSTRUMENT_DETAIL_KEY, instrumentAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_instrument_list, menu);
//        final MenuItem searchItem = menu.findItem(R.id.action_search);
//        final SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                // Reset SearchView
//                searchView.clearFocus();
//                searchView.setQuery("", false);
//                searchView.setIconified(true);
//                searchItem.collapseActionView();
//                acousticGuitars = InstrumentProvider.generateAcousticGuitars();
//                //complete SearchActivity by yourself
//                ArrayList<AcousticGuitar> SearchArray = new ArrayList<>();
//                for (int i = 0; i < 10; i++) {
//                    //AcousticGuitar temp = acousticGuitars.get(i);
//                    //String brand = temp.getBrand();
//                    //String brand = "fender";//acousticGuitars.get(i).getBrand();
//                    String brand = acousticGuitars.get(i).getBrand();
//                    if (brand.equalsIgnoreCase(query)){
//                        SearchArray.add(acousticGuitars.get(i));
//                    }
//                }
//                setContentView(R.layout.activity_main);
//                listView = (ListView) findViewById(R.id.listView);
//                acousticGuitarsAdapter = new AcousticGuitarsAdapter(ListActivity.this,
//                        SearchArray);
//                listView.setAdapter(acousticGuitarsAdapter);
//                LinearLayoutManager lm = new LinearLayoutManager(ListActivity.this);
//                setupSelectedInstrumentListener();
//
//                // Set activity title to search query
//                ListActivity.this.setTitle(query);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                return false;
//            }
//        });
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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

