package com.example.aunshon.meal;


import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Moneyfragment extends Fragment {

    SharedPreferences CheckingForNewMonth,memberinput;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences;
    TextView month,m1T,m2T,m3T,m4T,m5T,m6T,m7T,m8T,m9T,m10T,total_amount,meal_rate,total_expence,cash;
    TextView g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,total,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10;
    public static SqliteDatabaseHelper sqliteDatabaseHelper=null;
    String TABLE_N;
    public  static SQLiteDatabase setupDB=null;

    public Moneyfragment() {
        // Required empty public constructor
    }
    @Override
    public void onResume() {
        super.onResume();

        sqliteDatabaseHelper=new SqliteDatabaseHelper(getContext());
        setupDB=sqliteDatabaseHelper.getWritableDatabase();

        int meal1=0,meal2=0,meal3=0,meal4=0,meal5=0,meal6=0,meal7=0,meal8=0,meal9=0,meal10=0,totalexp=0;
        int ind1=0,ind2=0,ind3=0,ind4=0,ind5=0,ind6=0,ind7=0,ind8=0,ind9=0,ind10=0;

        Cursor c=setupDB.rawQuery("select * from "+TABLE_N,null);
        while (c.moveToNext())
        {
            //indevisual meal
            String i1=c.getString(0);
            ind1 += Integer.parseInt(i1);

            String i2=c.getString(1);
            ind2 += Integer.parseInt(i2);

            String i3=c.getString(2);
            ind3 += Integer.parseInt(i3);

            String i4=c.getString(3);
            ind4 += Integer.parseInt(i4);

            String i5=c.getString(4);
            ind5 += Integer.parseInt(i5);

            String i6=c.getString(5);
            ind6 += Integer.parseInt(i6);

            String i7=c.getString(6);
            ind7 += Integer.parseInt(i7);

            String i8=c.getString(7);
            ind8 += Integer.parseInt(i8);

            String i9=c.getString(8);
            ind9 += Integer.parseInt(i9);

            String i10=c.getString(9);
            ind10 += Integer.parseInt(i10);
            /////////////////////
            String a=c.getString(10);
            meal1 += Integer.parseInt(a);

            String b=c.getString(11);
            meal2 += Integer.parseInt(b);

            String cc=c.getString(12);
            meal3 += Integer.parseInt(cc);

            String d=c.getString(13);
            meal4 += Integer.parseInt(d);

            String e=c.getString(14);
            meal5 += Integer.parseInt(e);

            String f=c.getString(15);
            meal6 += Integer.parseInt(f);

            String g=c.getString(16);
            meal7 += Integer.parseInt(g);

            String h=c.getString(17);
            meal8 += Integer.parseInt(h);

            String i=c.getString(18);
            meal9 += Integer.parseInt(i);

            String j=c.getString(19);
            meal10 += Integer.parseInt(j);

            String k=c.getString(20);
            totalexp += Integer.parseInt(k);
        }
        int totalamount=meal1+meal2+meal3+meal4+meal5+meal6+meal7+meal8+meal9+meal10;
        int totalmeal=ind1+ind2+ind3+ind4+ind5+ind6+ind7+ind8+ind9+ind10;
        int existing_cash=totalamount-totalexp;

        total_amount.setText(String.valueOf(totalamount));
        total_expence.setText(String.valueOf(totalexp));
        cash.setText(String.valueOf(existing_cash));

        g1.setText(String.valueOf(meal1));g3.setText(String.valueOf(meal3));g5.setText(String.valueOf(meal5));g7.setText(String.valueOf(meal7));g9.setText(String.valueOf(meal9));
        g2.setText(String.valueOf(meal2));g4.setText(String.valueOf(meal4));g6.setText(String.valueOf(meal6));g8.setText(String.valueOf(meal8));g10.setText(String.valueOf(meal10));
        if (totalexp==0){
            Toast.makeText(getContext(), "No expence in this month so meal rate is 0", Toast.LENGTH_SHORT).show();
            meal_rate.setText("0");
        }
        else {
            double mealrate=totalexp/totalmeal;
            meal_rate.setText(String.valueOf(mealrate));
        }


    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_moneyfragment, container, false);
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

        e1=view.findViewById(R.id.e1);
        e2=view.findViewById(R.id.e2);
        e3=view.findViewById(R.id.e3);
        e4=view.findViewById(R.id.e4);
        e5=view.findViewById(R.id.e5);
        e6=view.findViewById(R.id.e6);
        e7=view.findViewById(R.id.e7);
        e8=view.findViewById(R.id.e8);
        e9=view.findViewById(R.id.e9);
        e10=view.findViewById(R.id.e10);

        d1=view.findViewById(R.id.d1);
        d2=view.findViewById(R.id.d2);
        d3=view.findViewById(R.id.d3);
        d4=view.findViewById(R.id.d4);
        d5=view.findViewById(R.id.d5);
        d6=view.findViewById(R.id.d6);
        d7=view.findViewById(R.id.d7);
        d8=view.findViewById(R.id.d8);
        d9=view.findViewById(R.id.d9);
        d10=view.findViewById(R.id.d10);
        total_amount=view.findViewById(R.id.total_amount);
        total_expence=view.findViewById(R.id.total_expence);
        meal_rate=view.findViewById(R.id.meal_rate);
        cash=view.findViewById(R.id.cash);

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        int year = cal.get(Calendar.YEAR);
        String TABLE_NAME="AccounceOf"+month_name+year;
        month.setText(TABLE_NAME);
        TABLE_N=month_name+year;
        memberinput=getContext().getSharedPreferences("Member",MODE_PRIVATE);
        member_saving_to_sharedprefrences=memberinput.edit();
        m1T.setText(memberinput.getString("m1","Member1"));m6T.setText(memberinput.getString("m6","Member6"));
        m2T.setText(memberinput.getString("m2","Member2"));m7T.setText(memberinput.getString("m7","Member7"));
        m3T.setText(memberinput.getString("m3","Member3"));m8T.setText(memberinput.getString("m8","Member8"));
        m4T.setText(memberinput.getString("m4","Member4"));m9T.setText(memberinput.getString("m9","Member9"));
        m5T.setText(memberinput.getString("m5","Member5"));m10T.setText(memberinput.getString("m10","Member10"));
        return view;
    }

}
