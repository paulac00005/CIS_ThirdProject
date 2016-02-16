package com.example.paulac.cis;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View sender) {
        if(sender.getId() == R.id.login){
            LoginTask loginTask = new LoginTask();
        }
    }

    private class LoginTask extends AsyncTask <String, Void, Void>{

        @Override
        protected Void doInBackground(String... params) {
            return null;
        }
    }
}
