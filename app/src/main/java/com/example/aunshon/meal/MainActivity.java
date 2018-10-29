package com.example.aunshon.meal;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    SharedPreferences CheckingForNewMonth,memberinput;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences;
    LinearLayout newmonth,entry;
    SqliteDatabaseHelper sqliteDatabaseHelper;
    TextView monthinput,yearinput;
    Button deshboard;
    String month_name;
    int year;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newmonth=findViewById(R.id.newMonthlayout);
        entry=findViewById(R.id.entrylayout);
        monthinput=findViewById(R.id.month_input);
        yearinput=findViewById(R.id.year_input);
        deshboard=findViewById(R.id.deshboard);

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        month_name = month_date.format(cal.getTime());
        monthinput.setText(month_name);
        year = cal.get(Calendar.YEAR);
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
        Intent intent=new Intent(MainActivity.this,DeshBoard.class);
        startActivity(intent);
    }

    public void NewMonthBtn(View view) {
        Intent intent=new Intent(MainActivity.this,MemberAdd.class);
        startActivity(intent);
    }

    public void EditMenu(MenuItem item) {
        Intent intent=new Intent(MainActivity.this,Edit.class);
        startActivity(intent);
    }
//
//    public void CloseMonth(MenuItem item) {
//
//        if (CheckingForNewMonth.getBoolean("checkmonth",true)==true){
//            Toast.makeText(this, "Please Create a new month", Toast.LENGTH_SHORT).show();
//        }
//        else {
//
//
//        }
//    }

    public void anoutMenu(MenuItem item) {
        Intent intent=new Intent(MainActivity.this,About.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainactivity,menu);
        return true;
    }

    public void exitMenu(MenuItem item) {
        finish();
        System.exit(0);
    }

    public void HistoryMenu(MenuItem item) {
        Toast.makeText(this, "Under Development", Toast.LENGTH_SHORT).show();
    }
}
