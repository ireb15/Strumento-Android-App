package com.example.instrument_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String ACOUSTIC_GUITAR_DETAIL_KEY = "acoustic guitar";

    ListView lvAcousticGuitars;
    InstrumentAdapter acousticGuitarAdapter;
    ArrayList<AcousticGuitar> acousticGuitars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvAcousticGuitars = (ListView) findViewById(R.id.lvAcousticGuitars);
        ArrayList<AcousticGuitar> acousticGuitars = new ArrayList<AcousticGuitar>();

        acousticGuitars = InstrumentProvider.generateAcousticGuitars();
        acousticGuitarAdapter = new InstrumentAdapter(this, acousticGuitars);

        lvAcousticGuitars.setAdapter(acousticGuitarAdapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);

    }
}
