package com.example.java_basic_app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Integer vaultOpened = 0;
    int maxWork = 0;
    int wage = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (SecondActivity.vaultOpen == 1) {
            wage = SecondActivity.wage;
            ((TextView) findViewById(R.id.money)).setText(SecondActivity.coinCount.toString());
            ((TextView) findViewById(R.id.wage)).setText(SecondActivity.wage.toString());
            ((TextView) findViewById(R.id.shop_button)).setText("        VAULT (0)              ");
        }
    }


    public void goToSecond(View v) {

        String countString = ((TextView) findViewById(R.id.money)).getText().toString();
        Integer count = Integer.parseInt(countString);

        if (SecondActivity.vaultOpen == 1) {
            vaultOpened++;
            Intent myI = new Intent(this, SecondActivity.class);
            String coins = ((TextView) findViewById(R.id.money)).getText().toString();
            String wage = ((TextView) findViewById(R.id.wage)).getText().toString();
            myI.putExtra("COINS", coins);
            myI.putExtra("WAGE", wage);
            myI.putExtra("VAULT", vaultOpened.toString());
            startActivity(myI);
        } else {
            if (count >= 1000) {
                vaultOpened++;
                Intent myI = new Intent(this, SecondActivity.class);
                String coins = ((TextView) findViewById(R.id.money)).getText().toString();
                String wage = ((TextView) findViewById(R.id.wage)).getText().toString();
                myI.putExtra("COINS", coins);
                myI.putExtra("WAGE", wage);
                myI.putExtra("VAULT", vaultOpened.toString());
                startActivity(myI);
            } else {
                Toast.makeText(this, "Not enough coins", Toast.LENGTH_LONG).show();
            }
        }
    }


    public void getMoney(View v) {

        if (maxWork < 9) {
            int wageIncrease = (int)(Math.random() * 7);

            if (wageIncrease == 1) {
                wage += 5;
                Toast.makeText(this, "You got a pay raise!", Toast.LENGTH_LONG).show();
                Integer wageAmnt = wage;
                ((TextView) findViewById(R.id.wage)).setText(wageAmnt.toString());
            }

            String countString = ((TextView) findViewById(R.id.money)).getText().toString();
            Integer count = Integer.parseInt(countString);
            count += wage;
            ((TextView) findViewById(R.id.money)).setText(count.toString());
            maxWork++;
        } else {
            String countString = ((TextView) findViewById(R.id.money)).getText().toString();
            Integer count = Integer.parseInt(countString);
            count += wage;
            ((TextView) findViewById(R.id.money)).setText(count.toString());

            findViewById(R.id.money_button).setAlpha(0.6f);
            findViewById(R.id.money_button).setEnabled(false);
            Toast.makeText(this, "You're too tired to work!", Toast.LENGTH_LONG).show();
        }
    }


    public void vacation(View v) {

        String countString = ((TextView) findViewById(R.id.money)).getText().toString();
        Integer count = Integer.parseInt(countString);

        if (count >= 20) {
            count -= 20;
            ((TextView) findViewById(R.id.money)).setText(count.toString());
            maxWork = 0;
            findViewById(R.id.money_button).setEnabled(true);
            Toast.makeText(this, "You went on vacation", Toast.LENGTH_LONG).show();
            findViewById(R.id.money_button).setAlpha(1);
        } else {
            Toast.makeText(this, "Not enough coins", Toast.LENGTH_LONG).show();
        }
    }
}