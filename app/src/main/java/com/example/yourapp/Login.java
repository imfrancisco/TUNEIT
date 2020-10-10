package com.example.yourapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText mTextUsername;
    private EditText mTextPassword;
    private Button mButtonLogin;
    private TextView mTextViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mTextUsername = (EditText)findViewById(R.id.editText_username);
        mTextPassword = (EditText)findViewById(R.id.editText_password);

        mButtonLogin = (Button)findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Checks if the fields are empty
                // If they are empty, "Fields cannot be empty" will be displayed
                if(TextUtils.isEmpty(mTextUsername.getText().toString()) || TextUtils.isEmpty(mTextPassword.getText().toString())){
                    Toast.makeText(Login.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    // By clicking the Login button, we will be able to log into the next application page
                    // All of the fields must not be empty in order for this to take place
                    Intent logIntoApp = new Intent(Login.this, LoginScreen.class);
                    startActivity(logIntoApp);
                }
            }
        });

        mTextViewRegister = (TextView)findViewById(R.id.textView_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // By clicking the Register textView, we will be able to go into the Registration page
                Intent registerIntent = new Intent(Login.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}