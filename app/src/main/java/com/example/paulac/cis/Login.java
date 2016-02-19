package com.example.paulac.cis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends AppCompatActivity {

    private EditText Username, Password;
    private Button login;
    private static final String login_url = "http://10.4.101.44/sbs/login.php";
    protected final String key = "70930f27";

    /*private String error;
    InputStream is1;
    String text;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
    }

    public void signup(View v){
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }
}














































    /*@Override
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

                while(true)
                {
                    text += line + "\n";
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            text = text.trim();

            Toast.makeText(Login.this, text, Toast.LENGTH_LONG).show();

            if (text.equals("login_success")) {
                Intent in = new Intent(Login.this, Draft.class);
                startActivity(in);
            } else {
                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }
}*/
