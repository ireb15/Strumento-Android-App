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
    AcousticGuitarsAdapter acousticGuitarsAdapter;
    ElectricGuitarsAdapter electricGuitarsAdapter;
    PianosAdapter pianosAdapter;
    UkulelesAdapter ukulelesAdapter;
    DrumsAdapter drumsAdapter;
    ArrayList<AcousticGuitar> acousticGuitars;

    static String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        category=intent.getStringExtra(Intent.EXTRA_TEXT);
        if (category.equals("acoustic guitars")) {
            ArrayList<AcousticGuitar> acousticGuitars = InstrumentProvider.
                    generateAcousticGuitars();
            acousticGuitarsAdapter = new AcousticGuitarsAdapter(this, acousticGuitars);
            listView.setAdapter(acousticGuitarsAdapter);
        } else if (category.equals("electric guitars")) {
            ArrayList<ElectricGuitar> electricGuitars = InstrumentProvider.
                    generateElectricGuitars();
            electricGuitarsAdapter = new ElectricGuitarsAdapter(this, electricGuitars);
            listView.setAdapter(electricGuitarsAdapter);
        } else if (category.equals("pianos")) {
            ArrayList<Piano> pianos = InstrumentProvider.
                    generatePianos();
            pianosAdapter = new PianosAdapter(this, pianos);
            listView.setAdapter(pianosAdapter);
        } else if (category.equals("ukuleles")) {
            ArrayList<Ukulele> ukuleles = InstrumentProvider.
                    generateUkuleles();
            ukulelesAdapter = new UkulelesAdapter(this, ukuleles);
            listView.setAdapter(ukulelesAdapter);
        } else if (category.equals("drums")){
            ArrayList<Drum> drums = InstrumentProvider.
                    generateDrums();
            drumsAdapter = new DrumsAdapter(this, drums);
            listView.setAdapter(drumsAdapter);
        }


        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupSelectedInstrumentListener();

    }


    public void setupSelectedInstrumentListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(ListActivity.this, InstrumentDetailActivity.class);
                INSTRUMENT_DETAIL_KEY = category;
                if (category.equals("acoustic guitar")) {
                    intent.putExtra(INSTRUMENT_DETAIL_KEY, acousticGuitarsAdapter.getItem(position));
                } else if (category.equals("electric guitar")) {
                    intent.putExtra(INSTRUMENT_DETAIL_KEY, electricGuitarsAdapter.getItem(position));
                } else if (category.equals("pianos")) {
                    intent.putExtra(INSTRUMENT_DETAIL_KEY, pianosAdapter.getItem(position));
                } else if (category.equals("ukuleles")) {
                    intent.putExtra(INSTRUMENT_DETAIL_KEY, ukulelesAdapter.getItem(position));
                } else if (category.equals("drums")){
                    intent.putExtra(INSTRUMENT_DETAIL_KEY, drumsAdapter.getItem(position));
                }
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
                acousticGuitars = InstrumentProvider.generateAcousticGuitars();
                //complete SearchActivity by yourself
                ArrayList<AcousticGuitar> SearchArray = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    //AcousticGuitar temp = acousticGuitars.get(i);
                    //String brand = temp.getBrand();
                    //String brand = "fender";//acousticGuitars.get(i).getBrand();
                    String brand = acousticGuitars.get(i).getBrand();
                    if (brand.equalsIgnoreCase(query)){
                        SearchArray.add(acousticGuitars.get(i));
                    }
                }
                setContentView(R.layout.activity_main);
                listView = (ListView) findViewById(R.id.listView);
                acousticGuitarsAdapter = new AcousticGuitarsAdapter(ListActivity.this,
                        SearchArray);
                listView.setAdapter(acousticGuitarsAdapter);
                LinearLayoutManager lm = new LinearLayoutManager(ListActivity.this);
                setupSelectedInstrumentListener();

                // Set activity title to search query
                ListActivity.this.setTitle(query);
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

