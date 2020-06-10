package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static final String ACOUSTIC_GUITAR_DETAIL_KEY = "acoustic guitar";

    ListView lvAcousticGuitars;
    AcousticGuitarsAdapter acousticGuitarsAdapter;
    ArrayList<AcousticGuitar> acousticGuitars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvAcousticGuitars = (ListView) findViewById(R.id.lvAcousticGuitars);
        ArrayList<AcousticGuitar> acousticGuitars = new ArrayList<AcousticGuitar>();

        acousticGuitars = InstrumentProvider.generateAcousticGuitars();
        acousticGuitarsAdapter = new AcousticGuitarsAdapter(this, acousticGuitars);

        lvAcousticGuitars.setAdapter(acousticGuitarsAdapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);

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
                MainActivity.this.setTitle(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

}

