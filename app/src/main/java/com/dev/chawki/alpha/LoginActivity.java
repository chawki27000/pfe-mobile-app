package com.dev.chawki.alpha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    public static final String URL = "http://localhost:3000/";

    private Button button_connection;
    private EditText edittext_username;
    private EditText edittext_password;

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // binding
        button_connection = (Button) findViewById(R.id.button_connection);
        edittext_username = (EditText) findViewById(R.id.edittext_username);
        edittext_password = (EditText) findViewById(R.id.edittext_password);

        // clique event
        button_connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getting
                String username = edittext_username.getText().toString();
                String password = edittext_password.getText().toString();
                edittext_username.setText("");
                edittext_password.setText("");

                // AsyncRequest
                AsyncRequest request = new AsyncRequest();
                request.execute(Constants.URL, username, password);



            }
        });
    }

    private class AsyncRequest extends AsyncTask<String, Void, String> {

        public final MediaType JSON
                = MediaType.parse("application/x-www-form-urlencoded");

        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... params) {

            // FormBuilder
            RequestBody formBody = new FormBody.Builder()
                    .add("username", params[1])
                    .add("password", params[2])
                    .build();

            // Lunch request
            Request request = new Request.Builder()
                    .url(params[0]+"auth/login/")
                    .post(formBody)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd = ProgressDialog.show(LoginActivity.this, "Chargement", "Veuillez patienter...");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();

            // Parsing variable
            boolean success;

            // Parsing JSON
            try {
                JSONObject jsonObj = new JSONObject(s);

                // parse
                success = jsonObj.getBoolean("success");

                if (success) {
                    Constants.user_id = jsonObj.getString("id");
                    Constants.token = jsonObj.getString("token");

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Nom d'utilisateur ou mot de passe erroné",
                            Snackbar.LENGTH_LONG)
                            .show();
                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
