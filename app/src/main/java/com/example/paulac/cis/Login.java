package com.example.paulac.cis;

import android.app.ProgressDialog;
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
            loginTask.execute("http://10.4.101.44/sbs/login.php");
        }
    }

    private class LoginTask extends AsyncTask <String, Void, Void> implements Login2 {

        ProgressDialog dialog = new ProgressDialog(Login.this);

        @Override
        public void onPreExecute(){
            dialog.setMessage("Sending Data");
            dialog.show();
        }
        Boolean result = false;

        @Override
        protected Void doInBackground(String... params) {
            return null;
        }

        @Override
        public void onPostExecute(){
            if(result==true){

            }
        }

    }

    protected void onPostExecute(Void arg0){

    }
}
