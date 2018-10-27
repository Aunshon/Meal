package com.example.aunshon.meal;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DeshBoard extends AppCompatActivity {

    LinearLayout fragmentcontainer;
    Button money_btn,meal_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desh_board);

        fragmentcontainer=findViewById(R.id.FragmentContainer);
        meal_btn=findViewById(R.id.meal_btn);
        money_btn=findViewById(R.id.money_btn);

        Moneyfragment moneyfragment=new Moneyfragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.FragmentContainer,moneyfragment,"moneyFragment");
        fragmentTransaction.commit();
    }

    public void meal_btn_Clicked(View view) {
        Mealfragment mealfragment=new Mealfragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.FragmentContainer,mealfragment,"mealFragment");
        fragmentTransaction.commit();
    }

    public void money_btn_Clicked(View view) {
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        int year = cal.get(Calendar.YEAR);
        String TABLE_NAME="Accounceof"+month_name+year;

        Toast.makeText(this, ""+TABLE_NAME, Toast.LENGTH_SHORT).show();

        Moneyfragment moneyfragment=new Moneyfragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.FragmentContainer,moneyfragment,"moneuFragment");
        fragmentTransaction.commit();
    }
}
