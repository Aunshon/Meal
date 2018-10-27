package com.example.aunshon.meal;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddMeal extends AppCompatActivity {

    SharedPreferences CheckingForNewMonth,memberinput;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences;
    EditText m1E,m2E,m3E,m4E,m5E,m6E,m7E,m8E,m9E,m10E,monthinput,yearinput;
    EditText m1m,m2m,m3m,m4m,m5m,m6m,m7m,m8m,m9m,m10m,expence;
    TextView m1T,m2T,m3T,m4T,m5T,m6T,m7T,m8T,m9T,m10T;
    LinearLayout addMealLayout;
    String TABLE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        monthinput=findViewById(R.id.month_input);
        yearinput=findViewById(R.id.year_input);
        m1E=findViewById(R.id.m1E);m2E=findViewById(R.id.m2E);m3E=findViewById(R.id.m3E);m4E=findViewById(R.id.m4E);m5E=findViewById(R.id.m5E);
        m6E=findViewById(R.id.m6E);m7E=findViewById(R.id.m7E);m8E=findViewById(R.id.m8E);m9E=findViewById(R.id.m9E);m10E=findViewById(R.id.m10E);

        m1m=findViewById(R.id.m1m);m2m=findViewById(R.id.m2m);m3m=findViewById(R.id.m3m);m4m=findViewById(R.id.m4m);m5m=findViewById(R.id.m5m);
        m6m=findViewById(R.id.m6m);m7m=findViewById(R.id.m7m);m8m=findViewById(R.id.m8m);m9m=findViewById(R.id.m9m);m10m=findViewById(R.id.m10m);
        expence=findViewById(R.id.expence);

        m1T=findViewById(R.id.m1T);m2T=findViewById(R.id.m2T);m3T=findViewById(R.id.m3T);m4T=findViewById(R.id.m4T);m5T=findViewById(R.id.m5T);
        m6T=findViewById(R.id.m6T);m7T=findViewById(R.id.m7T);m8T=findViewById(R.id.m8T);m9T=findViewById(R.id.m9T);m10T=findViewById(R.id.m10T);
        addMealLayout=findViewById(R.id.addMealLayout);

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        monthinput.setText(month_name);
        int year = cal.get(Calendar.YEAR);
        yearinput.setText(String.valueOf(year));
        TABLE_NAME=month_name+year;

        CheckingForNewMonth=getSharedPreferences("CheckingMonth",MODE_PRIVATE);
        memberinput=getSharedPreferences("Member",MODE_PRIVATE);
        member_saving_to_sharedprefrences=memberinput.edit();
        m1T.setText(memberinput.getString("m1","Member1"));m6T.setText(memberinput.getString("m6","Member6"));
        m2T.setText(memberinput.getString("m2","Member2"));m7T.setText(memberinput.getString("m7","Member7"));
        m3T.setText(memberinput.getString("m3","Member3"));m8T.setText(memberinput.getString("m8","Member8"));
        m4T.setText(memberinput.getString("m4","Member4"));m9T.setText(memberinput.getString("m9","Member9"));
        m5T.setText(memberinput.getString("m5","Member5"));m10T.setText(memberinput.getString("m10","Member10"));
    }

    public void DoneBtn(View view) {
        String sh=memberinput.getString("TABLE_NAME","TABLE_NAME");
        String tab=TABLE_NAME;
        if (sh.equals(tab)){
            SqliteDatabaseHelper sqliteDatabaseHelper=new SqliteDatabaseHelper(AddMeal.this);

            Boolean check=sqliteDatabaseHelper.AddMeal(m1E.getText().toString(),m2E.getText().toString(),m3E.getText().toString(),m4E.getText().toString()
                ,m5E.getText().toString(),m6E.getText().toString(),m7E.getText().toString(),m8E.getText().toString()
                ,m9E.getText().toString(),m10E.getText().toString(),m1m.getText().toString(),m2m.getText().toString(),m3m.getText().toString(),m4m.getText().toString(),m5m.getText().toString(),m6m.getText().toString(),m7m.getText().toString(),m8m.getText().toString(),m9m.getText().toString(),m10m.getText().toString(),expence.getText().toString());
            if (check.equals(true)){
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(AddMeal.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "Failed to Add Meal", Toast.LENGTH_SHORT).show();
            }
        }else {
            AlertDialog.Builder alertdialog=new AlertDialog.Builder(AddMeal.this);
            alertdialog.setTitle("Sorry This month is over !");
            alertdialog.setMessage("Close this month by pressing (Close Month) form top Left menu of this page");
            alertdialog.setCancelable(true).setNeutralButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertdialog.show();
        }
    }
}
