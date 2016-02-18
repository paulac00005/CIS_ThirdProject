package com.example.paulac.cis;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText Username, Password;
    private Button login;
    private static final String login_url = "http://10.4.101.44/sbs/login.php";
    protected final String key = "70930f27";

    private String error;
    InputStream is1;
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login) {
            SignUpTask signUpTask = new SignUpTask();
            signUpTask.execute(login_url);
        }
    }


    private class SignUpTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog = new ProgressDialog(Login.this);

        @Override
        protected void onPreExecute() {
            dialog.setMessage("Sending Data . . .");
            dialog.show();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(result == true){
                Toast.makeText(Login.this, "Inserted", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(Login.this, "Error inserting data . . .", Toast.LENGTH_SHORT).show();
            }
            dialog.dismiss();
        }

        Boolean result = false;

        String u = Username.getText().toString();
        String p = Password.getText().toString();

        @Override
        protected Boolean doInBackground(String... url) {

            for (String url1 : url) {
                try {
                    ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
                    pairs.add(new BasicNameValuePair("username", u));
                    pairs.add(new BasicNameValuePair("password", p));
                    pairs.add(new BasicNameValuePair("key", "70930f27"));

                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url1);
                    post.setEntity(new UrlEncodedFormEntity(pairs));
                    HttpResponse response = client.execute(post);
                    is1 = response.getEntity().getContent();

                    result = true;
                } catch (ClientProtocolException e) {
                    error +=  "\nClientProtocolException: " + e.getMessage();
                } catch (IOException e) {
                    error +=  "\nClientProtocolException: " + e.getMessage();
                }

            }

            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(is1, "iso-8859-1"),8);
                String line = null;

                while(true){
                    text += line + "\n";
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

    }
}
