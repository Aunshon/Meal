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
        db.execSQL("create table "+TABLE_NAME+" (m1 double,m2 double,m3 double,m4 double,m5 double,m6 double,m7 double,m8 double,m9 double,m10 double,m1m double,m2m double,m3m double,m4m double,m5m double,m6m double,m7m double,m8m double,m9m double,m10m double,expence double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public boolean AddMeal(String m1,String m2,String m3,String m4,String m5,String m6,String m7,String m8,String m9,String m10,String m1m,String m2m,String m3m,String m4m,String m5m,String m6m,String m7m,String m8m,String m9m,String m10m,String expence){
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
        contentValues.put("m1m",m1m);
        contentValues.put("m2m",m2m);
        contentValues.put("m3m",m3m);
        contentValues.put("m4m",m4m);
        contentValues.put("m5m",m5m);
        contentValues.put("m6m",m6m);
        contentValues.put("m7m",m7m);
        contentValues.put("m8m",m8m);
        contentValues.put("m9m",m9m);
        contentValues.put("m10m",m10m);
        contentValues.put("expence",expence);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }
}
