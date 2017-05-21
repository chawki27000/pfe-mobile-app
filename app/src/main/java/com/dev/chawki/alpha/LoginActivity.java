package com.dev.chawki.alpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    public static final String URL = "http://localhost:3000/";

    private Button button_connection;
    private EditText edittext_username;
    private EditText edittext_password;

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

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
