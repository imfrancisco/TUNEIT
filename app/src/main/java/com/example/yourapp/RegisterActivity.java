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

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private EditText mTextName, mTextLastName, mTextEmail, mTextBirthday, mTextUsername, mTextPassword, mTextConfirmPassword;
    private Button mButtonRegister;
    private TextView mTextViewLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextName = (EditText)findViewById(R.id.editText_name);
        mTextLastName= (EditText)findViewById(R.id.editText_lastName);
        mTextEmail = (EditText)findViewById(R.id.editText_email);
        mTextBirthday = (EditText)findViewById(R.id.editText_birthDay);
        mTextUsername = (EditText)findViewById(R.id.editText_username);
        mTextPassword = (EditText)findViewById(R.id.editText_password);
        mTextConfirmPassword = (EditText)findViewById(R.id.editText_confirmPassword);

        mButtonRegister = (Button)findViewById(R.id.button_register);
        mButtonRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // validateName() method is called to verify the name
                validateName();

                // validateLastName() method is called to verify the last name
                validateLastName();

                // validateEmail() method is called to verify the email
                validateEmail();

                // validateUsername() method is called to verify the username
                validateUserName();

                // validatePassword() method is called to verify the password
                validatePassword();

                // validateConfirmPassword() method is called to verify the confirm password
                validateConfirmPassword();

                // validateDateOfBirth method is called to verify the date of birth
                validateDateOfBirth();

                // This if statement checks if the fields are empty
                // If the fields are empty, the message "fields cannot be empty" will be displayed
                if(TextUtils.isEmpty(mTextName.getText().toString()) || TextUtils.isEmpty(mTextLastName.getText().toString()) ||
                        TextUtils.isEmpty(mTextEmail.getText().toString()) || TextUtils.isEmpty(mTextBirthday.getText().toString()) ||
                        TextUtils.isEmpty(mTextUsername.getText().toString()) || TextUtils.isEmpty(mTextPassword.getText().toString()) ||
                        TextUtils.isEmpty(mTextConfirmPassword.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    // If the fields are validated, it will take the user to the login page
                    if((validateEmail() && validateName() && validateLastName() && validateUserName() && validatePassword() && validateConfirmPassword() && validateDateOfBirth())==true) {
                        Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, Login.class);
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        mTextViewLogin = (TextView)findViewById(R.id.textView_login);

        // By clicking the Login TextView, you will be able to go into the Login page
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this,Login.class);
                startActivity(LoginIntent);
            }
        });
    }

    // This method will validate email
    protected boolean validateEmail(){
        String emailInput = mTextEmail.getText().toString().trim();
        if(!EMAIL_ADDRESS.matcher(emailInput).matches()) {
            mTextEmail.setError("Please enter a valid email address");
            return false;
        }
        else{
            return true;
        }
    }

    // This is the pattern to validate Email
    public static final Pattern EMAIL_ADDRESS = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+");


    // This method will validate name
    public boolean validateName(){
        String nameInput = mTextName.getText().toString().trim();
        if(!NAME_VALIDATION.matcher(nameInput).matches()) {
            mTextName.setError("Please enter a valid name");
            return false;
        }
        else {
            return true;
        }
    }

    // This is the pattern to validate last name
    public static final Pattern NAME_VALIDATION = Pattern.compile("[a-zA-z\\s]{3,30}");

    // This method will validate name
    public boolean validateLastName(){
        String LastNameInput = mTextLastName.getText().toString().trim();
        if(!LASTNAME_VALIDATION.matcher(LastNameInput).matches()) {
            mTextLastName.setError("Please enter a valid last name");
            return false;
        }
        else {
            return true;
        }
    }

    // This is the pattern to validate last name
    public static final Pattern LASTNAME_VALIDATION = Pattern.compile("[a-zA-z\\s]{3,30}");

    // This method will validate username
    public boolean validateUserName(){
        String userNameInput = mTextUsername.getText().toString().trim();
        if(!USERNAME_VALIDATION.matcher(userNameInput).matches()) {
            mTextUsername.setError("Please enter a valid last name");
            return false;
        }
        else {
            return true;
        }
    }

    // This is the pattern to validate last name
    public static final Pattern USERNAME_VALIDATION = Pattern.compile("[a-zA-z\\s]{3,30}");


    // This method will validate the password
    public boolean validatePassword(){
        String passwordInput = mTextPassword.getText().toString().trim();
        if(!PASSWORD_VALIDATION.matcher(passwordInput).matches()) {
            mTextPassword.setError("Password too weak");
            return false;
        }
        else {
            return true;
        }
    }

    // This is the pattern to validate the password
    public static final Pattern PASSWORD_VALIDATION = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{1,}");

    // This method will validate the password
    public boolean validateConfirmPassword(){
        String confirmPasswordInput = mTextConfirmPassword.getText().toString().trim();
        if(!PASSWORD_VALIDATION.matcher(confirmPasswordInput).matches()) {
            mTextConfirmPassword.setError("Password too weak");
            return false;
        }
        else {
            return true;
        }
    }

    // This method will validate the date of Birth
    public boolean validateDateOfBirth(){
        String dateOfBirthInput = mTextBirthday.getText().toString().trim();
        if(!DATE_OF_BIRTH_VALIDATION.matcher(dateOfBirthInput).matches()) {
            mTextBirthday.setError("Please enter mm/dd/yyyy");
            return false;
        }
        else {
            return true;
        }
    }

    // This is the pattern to validate the date of birth
    public static final Pattern DATE_OF_BIRTH_VALIDATION = Pattern.compile("^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$");


}