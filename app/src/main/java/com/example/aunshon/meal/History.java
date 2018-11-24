package com.example.aunshon.meal;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.Inflater;

public class History extends AppCompatActivity {

    TextView m1,m2,m3,m4,m5,m6,m7,m8,m9,m10;
    TextView m11,m12,m13,m14,m15,m16,m17,m18,m19,m110,m111,m112,m113,m114,m115,m116,m117,m118,m119,m120,m121,m122,m123,m124,m125,m126,m127,m128,m129,m130,m131;
    SharedPreferences CheckingForNewMonth,memberinput;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences;
    public static SqliteDatabaseHelper sqliteDatabaseHelper=null;
    String TABLE_N;
    public  static SQLiteDatabase setupDB=null;
    public static final String DatabaseName="Meal_Android.db";
    SharedPreferences VersionShare,Chander;
    SharedPreferences.Editor VersionEdit,ChanderEdit;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        spinner=findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(History.this,R.array.Spinner_item,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        m1=findViewById(R.id.member1);m3=findViewById(R.id.member3);m5=findViewById(R.id.member5);m7=findViewById(R.id.member7);m9=findViewById(R.id.member9);
        m2=findViewById(R.id.member2);m4=findViewById(R.id.member4);m6=findViewById(R.id.member6);m8=findViewById(R.id.member8);m10=findViewById(R.id.member10);

        m11=findViewById(R.id.m11);m17=findViewById(R.id.m17);m112=findViewById(R.id.m12);m117=findViewById(R.id.m117);m122=findViewById(R.id.m122);m127=findViewById(R.id.m127);
        m12=findViewById(R.id.m12);m18=findViewById(R.id.m18);m113=findViewById(R.id.m113);m118=findViewById(R.id.m118);m123=findViewById(R.id.m123);m128=findViewById(R.id.m128);
        m13=findViewById(R.id.m13);m19=findViewById(R.id.m19);m114=findViewById(R.id.m114);m119=findViewById(R.id.m119);m124=findViewById(R.id.m124);m129=findViewById(R.id.m129);
        m14=findViewById(R.id.m14);m110=findViewById(R.id.m110);m115=findViewById(R.id.m115);m120=findViewById(R.id.m120);m125=findViewById(R.id.m125);m130=findViewById(R.id.m130);
        m15=findViewById(R.id.m15);m111=findViewById(R.id.m111);m116=findViewById(R.id.m116);m121=findViewById(R.id.m121);m126=findViewById(R.id.m126);m131=findViewById(R.id.m131);
        m16=findViewById(R.id.m16);

        memberinput=getSharedPreferences("Member",MODE_PRIVATE);
        member_saving_to_sharedprefrences=memberinput.edit();
        m1.setText(memberinput.getString("m1","Member1"));m6.setText(memberinput.getString("m6","Member6"));
        m2.setText(memberinput.getString("m2","Member2"));m7.setText(memberinput.getString("m7","Member7"));
        m3.setText(memberinput.getString("m3","Member3"));m8.setText(memberinput.getString("m8","Member8"));
        m4.setText(memberinput.getString("m4","Member4"));m9.setText(memberinput.getString("m9","Member9"));
        m5.setText(memberinput.getString("m5","Member5"));m10.setText(memberinput.getString("m10","Member10"));


        int versionint=VersionShare.getInt("Version",1);
        sqliteDatabaseHelper=new SqliteDatabaseHelper(this,DatabaseName,null,versionint);
        setupDB=sqliteDatabaseHelper.getWritableDatabase();

        VersionShare=getSharedPreferences("VersionShareGlobal",MODE_PRIVATE);
        VersionEdit=VersionShare.edit();
        Chander=getSharedPreferences("truefalse",MODE_PRIVATE);
        ChanderEdit=Chander.edit();

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        int year = cal.get(Calendar.YEAR);
        String TABLE_NAME="Meal of "+month_name+" "+year;
        TABLE_N=month_name+year;

        int meal1=0,meal2=0,meal3=0,meal4=0,meal5=0,meal6=0,meal7=0,meal8=0,meal9=0,meal10=0;
        int test=1;

        Cursor c=setupDB.rawQuery("select * from "+TABLE_N,null);
        while (c.moveToNext())
        {
            String a=c.getString(0);
            m1.append(String.valueOf(test)).setText()

//            String b=c.getString(1);
//            meal2 += Integer.parseInt(b);
//
//            String cc=c.getString(2);
//            meal3 += Integer.parseInt(cc);
//
//            String d=c.getString(3);
//            meal4 += Integer.parseInt(d);
//
//            String e=c.getString(4);
//            meal5 += Integer.parseInt(e);
//
//            String f=c.getString(5);
//            meal6 += Integer.parseInt(f);
//
//            String g=c.getString(6);
//            meal7 += Integer.parseInt(g);
//
//            String h=c.getString(7);
//            meal8 += Integer.parseInt(h);
//
//            String i=c.getString(8);
//            meal9 += Integer.parseInt(i);
//
//            String j=c.getString(9);
//            meal10 += Integer.parseInt(j);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.historytop,menu);
        return true;
    }

    public void reload(MenuItem item) {
    }
}
