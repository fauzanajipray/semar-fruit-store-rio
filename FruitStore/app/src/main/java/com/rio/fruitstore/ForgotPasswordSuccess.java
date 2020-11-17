package com.rio.fruitstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgotPasswordSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_success);
    }

    public void clickGetStarted(View view) {
        Intent i = new Intent(ForgotPasswordSuccess.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}