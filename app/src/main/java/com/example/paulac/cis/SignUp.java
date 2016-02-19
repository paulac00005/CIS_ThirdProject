package com.example.paulac.cis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Spinner security = (Spinner)findViewById(R.id.spinner);
        String[] questions = new String[]{"--","What is the name of your first pet?",
                "What is your favorite movie?",
                "What is your favorite food?",
                "What is your favorite drink?",
                "What is your favorite color?"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, questions);
        security.setAdapter(adapter);

    }


}
