package com.rio.fruitstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edEmail, edPassword;
    String emailEmpty, emailNotValid, passwordEmpty, formEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        emailEmpty = "Email tidak boleh kosong";
        emailNotValid = "Gunakan format email";
        passwordEmpty = "Password tidak boleh kosong";
        formEmpty =  "Inputan tidak boleh kosong";

    }

    public void clickLogin(View view) {
        if(TextUtils.isEmpty(edEmail.getText().toString().trim())
                && TextUtils.isEmpty(edPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), formEmpty, Toast.LENGTH_SHORT).show();
            edEmail.setFocusable(true);
        }

        else if(TextUtils.isEmpty(edEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), emailEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (!isValidEmail(edEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), emailNotValid, Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(edPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), passwordEmpty, Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }
    }

    public void clickForgot(View view) {
        Intent i = new Intent(LoginActivity.this, ForgotPassword_1.class);
        startActivity(i);
    }

    public static boolean isValidEmail (CharSequence email) {
        return  (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}