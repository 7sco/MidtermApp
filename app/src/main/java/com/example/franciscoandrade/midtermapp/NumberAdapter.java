package com.example.franciscoandrade.midtermapp;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by franciscoandrade on 12/6/17.
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolderNumber> {

   ArrayList<Number> numberList;

   Context context;

    //FragmentManager fragmentManager = context.getSupportFragmentManager();


    public NumberAdapter(ArrayList<Number> numberList, Context context) {
        this.numberList = numberList;
        this.context=context;

    }

    @Override
    public ViewHolderNumber onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.number_list, null, false);

        return new ViewHolderNumber(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolderNumber holder, final int position) {


        holder.number.setText(numberList.get(position).getNumber()+"");

        holder.itemRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


    android.support.v4.app.FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();


                NumberFragment numberFragment= new NumberFragment();



                Bundle bundle = new Bundle();
                bundle.putInt("number", numberList.get(position).getNumber());
                numberFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.idframe, numberFragment ).addToBackStack("number").commit();



            }
        });


    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }

    public class ViewHolderNumber extends RecyclerView.ViewHolder {

        LinearLayout itemRecycler;
        TextView number;

        public ViewHolderNumber(View itemView) {
            super(itemView);

            number=(TextView)itemView.findViewById(R.id.recyclerTextView);

            itemRecycler=(LinearLayout)itemView.findViewById(R.id.itemRecycler);



        }
    }
}
