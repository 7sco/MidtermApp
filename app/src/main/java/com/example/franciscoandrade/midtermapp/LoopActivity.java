package com.example.franciscoandrade.midtermapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class LoopActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);

        text= (TextView)findViewById(R.id.textTextView);

        SubCargar subCargar= new SubCargar();
        subCargar.execute(0);

    }



    private class SubCargar extends AsyncTask<Integer, Integer, Integer> {


        private int x=0;



        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //progressBar.setVisibility(View.VISIBLE);
        }



        @Override
        protected Integer doInBackground(Integer... voids) {

//            In doInBackground(), write a loop that starts at the value passed
//            into the AsyncTask after running execute(0), and ends at 100,000.
//            For every loop, run publishProcess().

//            for(int i = voids[0]; i<=100000; i++){
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                publishProgress(i);
//            }


            for(int i = voids[0]; i<=100000; i++){

                publishProgress(i);
            }




            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {


            text.setText("Loops completed: "+values[0]);

//            int red= generateRandom();
//            int green = generateRandom();
//            int blue= generateRandom();
//
//            text.setText(String.valueOf(values[0]));
//
//            container.setBackgroundColor(Color.rgb(red, green, blue));



        }

        @Override
        protected void onPostExecute(Integer aVoid) {
            super.onPostExecute(aVoid);

            //progressBar.setVisibility(View.INVISIBLE);

//            In onPostExecute(), set the text of the text view “Loops completed: “,
//            followed by the number received from the return in doInBackground().
//                    Then create an intent to a new activity called “LoginActivity”.

            text.setText("Loops completed: "+aVoid);

            Intent intent= new Intent(getApplicationContext(), LoginActivity.class);
//            intent.putExtra("email", holder.email.getText().toString());
            startActivity(intent);



        }


        private int generateRandom(){
            return new Random().nextInt(256);
        }

    }
}
