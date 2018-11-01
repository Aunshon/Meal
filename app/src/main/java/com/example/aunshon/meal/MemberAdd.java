package com.example.aunshon.meal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MemberAdd extends AppCompatActivity {

    public static final String DatabaseName="Meal_Android.db";
    SharedPreferences CheckingForNewMonth,memberinput,VersionShare,Chander;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences,VersionEdit,ChanderEdit;
    EditText m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,monthinput,yearinput;
    SqliteDatabaseHelper sqliteDatabaseHelper;
    String TABLE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_add);

        m1=findViewById(R.id.m1);m2=findViewById(R.id.m2);m3=findViewById(R.id.m3);m4=findViewById(R.id.m4);
        m5=findViewById(R.id.m5);m6=findViewById(R.id.m6);m7=findViewById(R.id.m7);m8=findViewById(R.id.m8);
        m9=findViewById(R.id.m9);m10=findViewById(R.id.m10);
        monthinput=findViewById(R.id.month_input);
        yearinput=findViewById(R.id.year_input);

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        monthinput.setText(month_name);
        int year = cal.get(Calendar.YEAR);
        yearinput.setText(String.valueOf(year));
        TABLE_NAME=month_name+year;

        CheckingForNewMonth=getSharedPreferences("CheckingMonth",MODE_PRIVATE);
        memberinput=getSharedPreferences("Member",MODE_PRIVATE);

        VersionShare=getSharedPreferences("VersionShareGlobal",MODE_PRIVATE);
        VersionEdit=VersionShare.edit();
        Chander=getSharedPreferences("truefalse",MODE_PRIVATE);
        ChanderEdit=Chander.edit();

        member_saving_to_sharedprefrences=memberinput.edit();

        m1.setText(memberinput.getString("m1","Member1"));m6.setText(memberinput.getString("m6","Member6"));
        m2.setText(memberinput.getString("m2","Member2"));m7.setText(memberinput.getString("m7","Member7"));
        m3.setText(memberinput.getString("m3","Member3"));m8.setText(memberinput.getString("m8","Member8"));
        m4.setText(memberinput.getString("m4","Member4"));m9.setText(memberinput.getString("m9","Member9"));
        m5.setText(memberinput.getString("m5","Member5"));m10.setText(memberinput.getString("m10","Member10"));
    }

    public void DoneClicked(View view) {

        if(Chander.getBoolean("boolCheck",true)==true){
            int versionint=VersionShare.getInt("Version",1);
            Toast.makeText(this, "if true "+versionint, Toast.LENGTH_SHORT).show();
            sqliteDatabaseHelper=new SqliteDatabaseHelper(MemberAdd.this,DatabaseName,null,versionint);
        }
        else {
            int versionint=VersionShare.getInt("Version",1);
            int UpdateVertion=versionint+1;
            VersionEdit.putInt("Version",UpdateVertion);
            VersionEdit.apply();
            VersionEdit.commit();

            int GetUpdateVersion=VersionShare.getInt("Version",UpdateVertion);
            Toast.makeText(this, "else false "+GetUpdateVersion, Toast.LENGTH_SHORT).show();
            sqliteDatabaseHelper=new SqliteDatabaseHelper(MemberAdd.this,DatabaseName,null,GetUpdateVersion);
        }
        editor=CheckingForNewMonth.edit();
        editor.putBoolean("checkmonth",false);
        editor.apply();
        editor.commit();

        ChanderEdit.putBoolean("boolCheck",false);
        ChanderEdit.apply();
        ChanderEdit.commit(); 

        member_saving_to_sharedprefrences.putString("m1",m1.getText().toString());
        member_saving_to_sharedprefrences.putString("m2",m2.getText().toString());
        member_saving_to_sharedprefrences.putString("m3",m3.getText().toString());
        member_saving_to_sharedprefrences.putString("m4",m4.getText().toString());
        member_saving_to_sharedprefrences.putString("m5",m5.getText().toString());
        member_saving_to_sharedprefrences.putString("m6",m6.getText().toString());
        member_saving_to_sharedprefrences.putString("m7",m7.getText().toString());
        member_saving_to_sharedprefrences.putString("m8",m8.getText().toString());
        member_saving_to_sharedprefrences.putString("m9",m9.getText().toString());
        member_saving_to_sharedprefrences.putString("m10",m10.getText().toString());
        member_saving_to_sharedprefrences.putString("yearinput",yearinput.getText().toString());
        member_saving_to_sharedprefrences.putString("monthinput",monthinput.getText().toString());
        member_saving_to_sharedprefrences.putString("TABLE_NAME",TABLE_NAME);
        member_saving_to_sharedprefrences.apply();
        member_saving_to_sharedprefrences.commit();
        Toast.makeText(this, "Month Added Successfully..", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(MemberAdd.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
