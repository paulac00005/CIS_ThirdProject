package com.example.paulac.cis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private static final String url = "http://10.4.101.44/sbs/login.php";
    protected final String key = "70930f27";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

    }
}