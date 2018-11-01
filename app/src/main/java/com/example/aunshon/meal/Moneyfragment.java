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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Moneyfragment extends Fragment {

    public static final String DatabaseName="Meal_Android.db";
    SharedPreferences CheckingForNewMonth,memberinput,VersionShare,Chander;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences,VersionEdit,ChanderEdit;
    TextView month,m1T,m2T,m3T,m4T,m5T,m6T,m7T,m8T,m9T,m10T,total_amount,meal_rate,total_expence,cash;
    TextView g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,total,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10;
    public static SqliteDatabaseHelper sqliteDatabaseHelper=null;
    String TABLE_N;
    public  static SQLiteDatabase setupDB=null;
    DecimalFormat decimal=new DecimalFormat("#####.###");

    public Moneyfragment() {
        // Required empty public constructor
    }
    @Override
    public void onResume() {
        super.onResume();

        int versionint=VersionShare.getInt("Version",1);
        Toast.makeText(getContext(), "Version"+versionint, Toast.LENGTH_SHORT).show();
        sqliteDatabaseHelper=new SqliteDatabaseHelper(getContext(),DatabaseName,null,versionint);
        setupDB=sqliteDatabaseHelper.getWritableDatabase();

        double meal1=0,meal2=0,meal3=0,meal4=0,meal5=0,meal6=0,meal7=0,meal8=0,meal9=0,meal10=0,totalexp=0;
        double ind1=0,ind2=0,ind3=0,ind4=0,ind5=0,ind6=0,ind7=0,ind8=0,ind9=0,ind10=0;
        double indExp1=0,indExp2=0,indExp3=0,indExp4=0,indExp5=0,indExp6=0,indExp7=0,indExp8=0,indExp9=0,indExp10=0;
        double due1=0,due2=0,due3=0,due4=0,due5=0,due6=0,due7=0,due8=0,due9=0,due10=0;
        double mealrate = 0;

        Cursor c=setupDB.rawQuery("select * from "+TABLE_N,null);
        while (c.moveToNext())
        {
            //indevisual meal
            String i1=c.getString(0);
            ind1 += Double.parseDouble(i1);

            String i2=c.getString(1);
            ind2 += Double.parseDouble(i2);

            String i3=c.getString(2);
            ind3 += Double.parseDouble(i3);

            String i4=c.getString(3);
            ind4 += Double.parseDouble(i4);

            String i5=c.getString(4);
            ind5 += Double.parseDouble(i5);

            String i6=c.getString(5);
            ind6 += Double.parseDouble(i6);

            String i7=c.getString(6);
            ind7 += Double.parseDouble(i7);

            String i8=c.getString(7);
            ind8 += Double.parseDouble(i8);

            String i9=c.getString(8);
            ind9 += Double.parseDouble(i9);

            String i10=c.getString(9);
            ind10 += Double.parseDouble(i10);
            /////////////////////
            String a=c.getString(10);
            meal1 += Double.parseDouble(a);

            String b=c.getString(11);
            meal2 += Double.parseDouble(b);

            String cc=c.getString(12);
            meal3 += Double.parseDouble(cc);

            String d=c.getString(13);
            meal4 += Double.parseDouble(d);

            String e=c.getString(14);
            meal5 += Double.parseDouble(e);

            String f=c.getString(15);
            meal6 += Double.parseDouble(f);

            String g=c.getString(16);
            meal7 += Double.parseDouble(g);

            String h=c.getString(17);
            meal8 += Double.parseDouble(h);

            String i=c.getString(18);
            meal9 += Double.parseDouble(i);

            String j=c.getString(19);
            meal10 += Double.parseDouble(j);

            String k=c.getString(20);
            totalexp += Double.parseDouble(k);
        }
        double totalamount=meal1+meal2+meal3+meal4+meal5+meal6+meal7+meal8+meal9+meal10;
        double totalmeal=ind1+ind2+ind3+ind4+ind5+ind6+ind7+ind8+ind9+ind10;
        double existing_cash=totalamount-totalexp;

        total_amount.setText(String.valueOf(totalamount));
        total_expence.setText(String.valueOf(decimal.format(totalexp)));
        cash.setText(String.valueOf(decimal.format(existing_cash)));

        g1.setText(String.valueOf(decimal.format(meal1)));g3.setText(String.valueOf(decimal.format(meal3)));g5.setText(String.valueOf(decimal.format(meal5)));g7.setText(String.valueOf(decimal.format(meal7)));g9.setText(String.valueOf(decimal.format(meal9)));
        g2.setText(String.valueOf(decimal.format(meal2)));g4.setText(String.valueOf(decimal.format(meal4)));g6.setText(String.valueOf(decimal.format(meal6)));g8.setText(String.valueOf(decimal.format(meal8)));g10.setText(String.valueOf(decimal.format(meal10)));
        if (totalexp==0){
            Toast.makeText(getContext(), "No expence in this month so meal rate is 0", Toast.LENGTH_SHORT).show();
            meal_rate.setText("0");
        }
        else {
            mealrate=totalexp/totalmeal;
            meal_rate.setText(String.valueOf(decimal.format(mealrate)));
        }

        indExp1=ind1*mealrate;indExp3=ind3*mealrate;indExp5=ind5*mealrate;indExp7=ind7*mealrate;indExp9=ind9*mealrate;
        indExp2=ind2*mealrate;indExp4=ind4*mealrate;indExp6=ind6*mealrate;indExp8=ind8*mealrate;indExp10=ind10*mealrate;

        e1.setText(String.valueOf(decimal.format(indExp1)));e2.setText(String.valueOf(decimal.format(indExp2)));e3.setText(String.valueOf(decimal.format(indExp3)));e4.setText(String.valueOf(decimal.format(indExp4)));e5.setText(String.valueOf(decimal.format(indExp5)));
        e6.setText(String.valueOf(decimal.format(indExp6)));e7.setText(String.valueOf(decimal.format(indExp7)));e8.setText(String.valueOf(decimal.format(indExp8)));e9.setText(String.valueOf(decimal.format(indExp9)));e10.setText(String.valueOf(decimal.format(indExp10)));

        due1=meal1-indExp1;due2=meal2-indExp2;due3=meal3-indExp3;due4=meal4-indExp4;due6=meal6-indExp6;
        due7=meal7-indExp7;due8=meal8-indExp8;due9=meal9-indExp9;due10=meal10-indExp10;due5=meal5-indExp5;

        d1.setText(String.valueOf(decimal.format(due1)));d2.setText(String.valueOf(decimal.format(due2)));d3.setText(String.valueOf(decimal.format(due3)));d4.setText(String.valueOf(decimal.format(due4)));d5.setText(String.valueOf(decimal.format(due5)));
        d6.setText(String.valueOf(decimal.format(due6)));d7.setText(String.valueOf(decimal.format(due7)));d8.setText(String.valueOf(decimal.format(due8)));d9.setText(String.valueOf(decimal.format(due9)));d10.setText(String.valueOf(decimal.format(due10)));
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
        String TABLE_NAME="Accounce Of "+month_name+year;
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
