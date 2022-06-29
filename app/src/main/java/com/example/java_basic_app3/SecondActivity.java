package com.example.java_basic_app3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent myI = getIntent();
        Integer coinCount = Integer.parseInt(myI.getStringExtra("COINS"));
        ((TextView) findViewById(R.id.money2)).setText(coinCount.toString());
    }

    public void goToMain(View v) {
        Intent myAct = new Intent(this, MainActivity.class);
        startActivity(myAct);

    }
}