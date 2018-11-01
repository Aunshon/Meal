package com.example.aunshon.meal;


import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;


public class Mealfragment extends Fragment {

    SharedPreferences CheckingForNewMonth,memberinput;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences;
    TextView month,m1T,m2T,m3T,m4T,m5T,m6T,m7T,m8T,m9T,m10T;
    TextView g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,total;
    public static SqliteDatabaseHelper sqliteDatabaseHelper=null;
    String TABLE_N;
    public  static SQLiteDatabase setupDB=null;
    public static final String DatabaseName="Meal_Android.db";
    SharedPreferences VersionShare,Chander;
    SharedPreferences.Editor VersionEdit,ChanderEdit;

    public Mealfragment() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();

        int versionint=VersionShare.getInt("Version",1);
        Toast.makeText(getContext(), "Version "+versionint, Toast.LENGTH_SHORT).show();
        sqliteDatabaseHelper=new SqliteDatabaseHelper(getContext(),DatabaseName,null,versionint);
        setupDB=sqliteDatabaseHelper.getWritableDatabase();

        int meal1=0,meal2=0,meal3=0,meal4=0,meal5=0,meal6=0,meal7=0,meal8=0,meal9=0,meal10=0;

        Cursor c=setupDB.rawQuery("select * from "+TABLE_N,null);
        while (c.moveToNext())
        {
            String a=c.getString(0);
            meal1 += Integer.parseInt(a);

            String b=c.getString(1);
            meal2 += Integer.parseInt(b);

            String cc=c.getString(2);
            meal3 += Integer.parseInt(cc);

            String d=c.getString(3);
            meal4 += Integer.parseInt(d);

            String e=c.getString(4);
            meal5 += Integer.parseInt(e);

            String f=c.getString(5);
            meal6 += Integer.parseInt(f);

            String g=c.getString(6);
            meal7 += Integer.parseInt(g);

            String h=c.getString(7);
            meal8 += Integer.parseInt(h);

            String i=c.getString(8);
            meal9 += Integer.parseInt(i);

            String j=c.getString(9);
            meal10 += Integer.parseInt(j);
        }
        int totalMeal=meal1+meal2+meal3+meal4+meal5+meal6+meal7+meal8+meal9+meal10;
        g1.setText(String.valueOf(meal1));g3.setText(String.valueOf(meal3));g5.setText(String.valueOf(meal5));g7.setText(String.valueOf(meal7));g9.setText(String.valueOf(meal9));
        g2.setText(String.valueOf(meal2));g4.setText(String.valueOf(meal4));g6.setText(String.valueOf(meal6));g8.setText(String.valueOf(meal8));g10.setText(String.valueOf(meal10));
        total.setText(String.valueOf(totalMeal));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mealfragment, container, false);
        month=view.findViewById(R.id.month_input);
        m1T=view.findViewById(R.id.m1T);
        m2T=view.findViewById(R.id.m2T);
        m3T=view.findViewById(R.id.m3T);
        m4T=view.findViewById(R.id.m4T);
        m5T=view.findViewById(R.id.m5T);
        m6T=view.findViewById(R.id.m6T);
        m7T=view.findViewById(R.id.m7T);
        m8T=view.findViewById(R.id.m8T);
        m9T=view.findViewById(R.id.m9T);
        m10T=view.findViewById(R.id.m10T);

        g1=view.findViewById(R.id.g1);
        g2=view.findViewById(R.id.g2);
        g3=view.findViewById(R.id.g3);
        g4=view.findViewById(R.id.g4);
        g5=view.findViewById(R.id.g5);
        g6=view.findViewById(R.id.g6);
        g7=view.findViewById(R.id.g7);
        g8=view.findViewById(R.id.g8);
        g9=view.findViewById(R.id.g9);
        g10=view.findViewById(R.id.g10);
        total=view.findViewById(R.id.totalmeal);

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        int year = cal.get(Calendar.YEAR);
        String TABLE_NAME="Meal of "+month_name+" "+year;
        month.setText(TABLE_NAME);
        TABLE_N=month_name+year;
        memberinput=getContext().getSharedPreferences("Member",MODE_PRIVATE);
        member_saving_to_sharedprefrences=memberinput.edit();
        m1T.setText(memberinput.getString("m1","Member1"));m6T.setText(memberinput.getString("m6","Member6"));
        m2T.setText(memberinput.getString("m2","Member2"));m7T.setText(memberinput.getString("m7","Member7"));
        m3T.setText(memberinput.getString("m3","Member3"));m8T.setText(memberinput.getString("m8","Member8"));
        m4T.setText(memberinput.getString("m4","Member4"));m9T.setText(memberinput.getString("m9","Member9"));
        m5T.setText(memberinput.getString("m5","Member5"));m10T.setText(memberinput.getString("m10","Member10"));

        VersionShare=getContext().getSharedPreferences("VersionShareGlobal",MODE_PRIVATE);
        VersionEdit=VersionShare.edit();
        Chander=getContext().getSharedPreferences("truefalse",MODE_PRIVATE);
        ChanderEdit=Chander.edit();

        return view;

    }

}
