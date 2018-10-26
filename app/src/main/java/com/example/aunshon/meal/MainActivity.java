package com.example.aunshon.meal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    SharedPreferences CheckingForNewMonth;
    LinearLayout newmonth,entry;
    SqliteDatabaseHelper sqliteDatabaseHelper;
    TextView monthinput,yearinput;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newmonth=findViewById(R.id.newMonthlayout);
        entry=findViewById(R.id.entrylayout);
        monthinput=findViewById(R.id.month_input);
        yearinput=findViewById(R.id.year_input);

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        monthinput.setText(month_name);
        int year = cal.get(Calendar.YEAR);
        yearinput.setText(String.valueOf(year));

        CheckingForNewMonth=getSharedPreferences("CheckingMonth",MODE_PRIVATE);

        if (CheckingForNewMonth.getBoolean("checkmonth",true)==true){
            entry.setVisibility(-1);
            newmonth.setVisibility(1);
            newmonth.setGravity(Gravity.CENTER);
        }
        else {
            entry.setVisibility(1);
            newmonth.setVisibility(-1);
            entry.setGravity(Gravity.CENTER);
        }
    }

    public void AddMealBtn(View view) {
        Intent intent=new Intent(MainActivity.this,AddMeal.class);
        startActivity(intent);
    }

    public void deshboardBtn(View view) {
        Toast.makeText(this, "Funtionality not added", Toast.LENGTH_SHORT).show();
    }

    public void NewMonthBtn(View view) {
        Intent intent=new Intent(MainActivity.this,MemberAdd.class);
        startActivity(intent);
    }
}