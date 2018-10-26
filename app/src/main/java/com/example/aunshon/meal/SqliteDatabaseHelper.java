package com.example.aunshon.meal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SqliteDatabaseHelper extends SQLiteOpenHelper {
    public static final String DatabaseName="Meal_Android.db";
    Calendar cal=Calendar.getInstance();
    SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
    String month_name = month_date.format(cal.getTime());
    int year = cal.get(Calendar.YEAR);
    String TABLE_NAME=month_name+year;
    public SqliteDatabaseHelper(@Nullable Context context) {
        super(context, DatabaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (m1 integer,m2 integer,m3 integer,m4 integer,m5 integer,m6 integer,m7 integer,m8 integer,m9 integer,m10 integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public boolean AddMeal(String m1,String m2,String m3,String m4,String m5,String m6,String m7,String m8,String m9,String m10){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("m1",m1);
        contentValues.put("m2",m2);
        contentValues.put("m3",m3);
        contentValues.put("m4",m4);
        contentValues.put("m5",m5);
        contentValues.put("m6",m6);
        contentValues.put("m7",m7);
        contentValues.put("m8",m8);
        contentValues.put("m9",m9);
        contentValues.put("m10",m10);

        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }
}
