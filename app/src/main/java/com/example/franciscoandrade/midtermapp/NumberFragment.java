package com.example.franciscoandrade.midtermapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {

    View rootView;

    TextView text;


    public NumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView=inflater.inflate(R.layout.fragment_number, container, false);

        text=(TextView)rootView.findViewById(R.id.textNumberFragment);


        Bundle bundle=getArguments();
        Integer numberFromRecycler = bundle.getInt("number", 0);
        int total= numberFromRecycler*10;

        text.setText(total+"");


        Button btn=(Button)rootView.findViewById(R.id.buttonBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//               TextView textFragment= (TextView)rootView.findViewById(R.id.textFragment);
//                MainFragment mainFragment=new MainFragment();
               FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.idframe, mainFragment ).addToBackStack(null).commit();

fragmentManager.popBackStack();
//                Bundle bundle = new Bundle();
//                bundle.putString("email", "Coming from Numbers Fragments");
//                setArguments(bundle);

            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

}
