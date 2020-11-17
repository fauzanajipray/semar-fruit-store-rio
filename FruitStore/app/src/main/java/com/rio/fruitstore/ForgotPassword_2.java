package com.rio.fruitstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword_2 extends AppCompatActivity {

    EditText edCode,edPassword, edVerifPassword;
    String codeEmpty, codeMaxLength, passwordEmpty, formEmpty,  passwordVerifEmpty, passwordNotMatch, passwordMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_2);

        edCode = findViewById(R.id.edCode);
        edPassword = findViewById(R.id.edPassword);
        edVerifPassword = findViewById(R.id.edVerifPassword);

        formEmpty = "Inputan tidak boleh kososng";
        passwordEmpty = "Password tidak boleh kosong";
        passwordVerifEmpty = "Password Confirm tidak boleh kosong";
        passwordNotMatch = "Password tidak sama";
        passwordMax = "Password minimal 8 karakter";
        codeEmpty = "Code Reset tidak boleh kososng";
        codeMaxLength = "Code tidak boleh kurang dari 5-digit";

        String newPass = edPassword.getText().toString().trim();
        String confirmPass = edVerifPassword.getText().toString().trim();
    }

    public void clickConfirm(View view) {
        if(TextUtils.isEmpty(edCode.getText().toString().trim())){
            Toast.makeText(view.getContext(), codeEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (edCode.length() != 5){
            Toast.makeText(view.getContext(), codeMaxLength, Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(edVerifPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), passwordVerifEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(edPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), passwordEmpty, Toast.LENGTH_SHORT).show();
        }
        else if (edPassword.getText().toString().trim().length() < 8){
            Toast.makeText(view.getContext(), passwordMax, Toast.LENGTH_SHORT).show();
        }
        else if (!edPassword.getText().toString().trim().equals(edVerifPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), passwordNotMatch, Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(ForgotPassword_2.this, ForgotPasswordSuccess.class);
            startActivity(i);
            finish();
        }
    }
}