package com.example.franciscoandrade.midtermapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MainFragment mainFragment= new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.idframe, mainFragment).commit();

        Bundle extras= getIntent().getExtras();

        String value=extras.getString("email");

        Bundle bundle = new Bundle();
        bundle.putString("email", value);
        mainFragment.setArguments(bundle);





    }
}
