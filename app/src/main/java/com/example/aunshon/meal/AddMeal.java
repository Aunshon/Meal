package com.example.aunshon.meal;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddMeal extends AppCompatActivity {

    SharedPreferences CheckingForNewMonth,memberinput;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences;
    EditText m1E,m2E,m3E,m4E,m5E,m6E,m7E,m8E,m9E,m10E,monthinput,yearinput;
    TextView m1T,m2T,m3T,m4T,m5T,m6T,m7T,m8T,m9T,m10T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        monthinput=findViewById(R.id.month_input);
        yearinput=findViewById(R.id.year_input);
        m1E=findViewById(R.id.m1E);m2E=findViewById(R.id.m2E);m3E=findViewById(R.id.m3E);m4E=findViewById(R.id.m4E);m5E=findViewById(R.id.m5E);
        m6E=findViewById(R.id.m6E);m7E=findViewById(R.id.m7E);m8E=findViewById(R.id.m8E);m9E=findViewById(R.id.m9E);m10E=findViewById(R.id.m10E);

        m1T=findViewById(R.id.m1T);m2T=findViewById(R.id.m2T);m3T=findViewById(R.id.m3T);m4T=findViewById(R.id.m4T);m5T=findViewById(R.id.m5T);
        m6T=findViewById(R.id.m6T);m7T=findViewById(R.id.m7T);m8T=findViewById(R.id.m8T);m9T=findViewById(R.id.m9T);m10T=findViewById(R.id.m10T);

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        monthinput.setText(month_name);
        int year = cal.get(Calendar.YEAR);
        yearinput.setText(String.valueOf(year));

        CheckingForNewMonth=getSharedPreferences("CheckingMonth",MODE_PRIVATE);
        memberinput=getSharedPreferences("Member",MODE_PRIVATE);
        member_saving_to_sharedprefrences=memberinput.edit();
        m1T.setText(memberinput.getString("m1","Member1"));m6T.setText(memberinput.getString("m6","Member6"));
        m2T.setText(memberinput.getString("m2","Member2"));m7T.setText(memberinput.getString("m7","Member7"));
        m3T.setText(memberinput.getString("m3","Member3"));m8T.setText(memberinput.getString("m8","Member8"));
        m4T.setText(memberinput.getString("m4","Member4"));m9T.setText(memberinput.getString("m9","Member9"));
        m5T.setText(memberinput.getString("m5","Member5"));m10T.setText(memberinput.getString("m10","Member10"));
    }
}
