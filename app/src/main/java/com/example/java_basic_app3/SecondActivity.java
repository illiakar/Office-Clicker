package com.example.java_basic_app3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {



    Button firstFragmentBtn, secondFragmentBtn;
    static Integer coinCount = 0;
    static Integer wage = 10;
    static Integer vaultOpen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent myI = getIntent();
        coinCount = Integer.parseInt(myI.getStringExtra("COINS"));

        if (vaultOpen == 0) {
            coinCount -= 1000;
        }

        ((TextView) findViewById(R.id.money2)).setText(coinCount.toString());

        wage = Integer.parseInt(myI.getStringExtra("WAGE"));
        vaultOpen = Integer.parseInt(myI.getStringExtra("VAULT"));
        firstFragmentBtn = findViewById(R.id.fragment1_button);
        secondFragmentBtn = findViewById(R.id.fragment2_button);

        replaceFrag(new frag1());


        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Button) view).setTextColor(Color.parseColor("#09ff00"));
                ((Button) findViewById(R.id.fragment2_button)).setTextColor(Color.parseColor("#ffffff"));
                replaceFrag(new frag1());
            }
        });


        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Button) view).setTextColor(Color.parseColor("#09ff00"));
                ((Button) findViewById(R.id.fragment1_button)).setTextColor(Color.parseColor("#ffffff"));
                replaceFrag(new frag2());
            }
        });
    }


    private void replaceFrag(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();

    }


    public void goToMain(View v) {

        Intent myAct = new Intent(this, MainActivity.class);
        startActivity(myAct);

        vaultOpen = 0;

    }


    public void goToWork(View v) {

        coinCount = Integer.parseInt(((TextView) findViewById(R.id.money2)).getText().toString());

        Intent myAct = new Intent(this, MainActivity.class);
        startActivity(myAct);

    }


    public void buyCandyBar(View v) {

        String countString = ((TextView) findViewById(R.id.money2)).getText().toString();
        Integer count = Integer.parseInt(countString);

        if (count >= 3) {
            Toast.makeText(this, "Thank you for your purchase!", Toast.LENGTH_LONG).show();
            count -= 3;
            ((TextView) findViewById(R.id.money2)).setText(count.toString());
        } else {
            Toast.makeText(this, "Not enough coins", Toast.LENGTH_LONG).show();
        }

    }


    public void buyIceCream(View v) {

        String countString = ((TextView) findViewById(R.id.money2)).getText().toString();
        Integer count = Integer.parseInt(countString);

        if (count >= 5) {
            Toast.makeText(this, "Thank you for your purchase!", Toast.LENGTH_LONG).show();
            count -= 5;
            ((TextView) findViewById(R.id.money2)).setText(count.toString());
        } else {
            Toast.makeText(this, "Not enough coins", Toast.LENGTH_LONG).show();
        }

    }


    public void buyFruitCup(View v) {

        String countString = ((TextView) findViewById(R.id.money2)).getText().toString();
        Integer count = Integer.parseInt(countString);

        if (count >= 9) {
            Toast.makeText(this, "Thank you for your purchase!", Toast.LENGTH_LONG).show();
            count -= 9;
            ((TextView) findViewById(R.id.money2)).setText(count.toString());
        } else {
            Toast.makeText(this, "Not enough coins", Toast.LENGTH_LONG).show();
        }

    }


    public void buyBrownies(View v) {

        String countString = ((TextView) findViewById(R.id.money2)).getText().toString();
        Integer count = Integer.parseInt(countString);

        if (count >= 7) {
            Toast.makeText(this, "Thank you for your purchase!", Toast.LENGTH_LONG).show();
            count -= 7;
            ((TextView) findViewById(R.id.money2)).setText(count.toString());
        } else {
            Toast.makeText(this, "Not enough coins", Toast.LENGTH_LONG).show();
        }
    }

}