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

    public static final String ACOUSTIC_GUITAR_DETAIL_KEY = "acoustic guitar";

    ListView lvAcousticGuitar;
    AcousticGuitarsAdapter acousticGuitarsAdapter;
    ArrayList<AcousticGuitar> acousticGuitars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvAcousticGuitar = (ListView) findViewById(R.id.lvAcousticGuitars);
        ArrayList<AcousticGuitar> acousticGuitars = new ArrayList<AcousticGuitar>();


        acousticGuitars = InstrumentProvider.generateAcousticGuitars();
        acousticGuitarsAdapter = new AcousticGuitarsAdapter(this, acousticGuitars);


        lvAcousticGuitar.setAdapter(acousticGuitarsAdapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupAcousticGuitarSelectedListener();

    }


    public void setupAcousticGuitarSelectedListener() {
        lvAcousticGuitar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing book as an extra
                Intent intent = new Intent(ListActivity.this, InstrumentDetailActivity.class);
                intent.putExtra(ACOUSTIC_GUITAR_DETAIL_KEY, acousticGuitarsAdapter.getItem(position));
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

                //complete SearchActivity by yourself


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
}

