package com.example.franciscoandrade.midtermapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    View rootView;

    TextView textFragment;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_main, container, false);

        textFragment= (TextView)rootView.findViewById(R.id.textFragment);


        Bundle bundle=getArguments();
        String value;


        if(bundle.getString("email") != null){

            value= bundle.getString("email");
            textFragment.setText(value+"");
        }
        else{
            textFragment.setText("Coming from other Fragment");

        }





        RecyclerView recyclerView=  rootView.findViewById(R.id.recyclerView);




        ArrayList<Number> numbersList= new ArrayList<>();

        for(int i=0; i<11; i++){
            numbersList.add(new Number(i));
        }


        NumberAdapter numberAdapter= new NumberAdapter(numbersList, rootView.getContext());
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false);


        recyclerView.setAdapter(numberAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);


        return rootView;
    }


}
