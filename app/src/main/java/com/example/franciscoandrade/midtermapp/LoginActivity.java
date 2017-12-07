package com.example.franciscoandrade.midtermapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY="sharedPrefsTesting";
    SharedPreferences sharedPreferences;

    EditText text1;
    EditText text2;
    CheckBox chkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        sharedPreferences= getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        text1=(EditText)findViewById(R.id.firstEditText);
        text2=(EditText)findViewById(R.id.secondEditText);
        chkBox=(CheckBox)findViewById(R.id.chkBox);


        text1.setText(sharedPreferences.getString("text1", "default"));
        text2.setText(sharedPreferences.getString("text2", "default"));


    }

    public void onClick(View view) {


        if(chkBox.isChecked() ){
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString("text1", text1.getText().toString());
            editor.putString("text2", text2.getText().toString());
            editor.commit();
        }


        if(text1.getText().toString().equals("user@aol.com") && text2.getText().toString().equals("password1234")){

            Intent intent= new Intent(getApplicationContext(), ListActivity.class);
            intent.putExtra("email", text1.getText().toString());
            startActivity(intent);


        }






    }
}
