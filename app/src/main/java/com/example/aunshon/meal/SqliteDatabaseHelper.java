package com.example.aunshon.meal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class SqliteDatabaseHelper extends SQLiteOpenHelper {
    public static final String DatabaseName="student_info.db";
    public static final String TableName="student";
    public static final String StudentName="name";
    public static final String StudentId="id";
    public static final String StudentPhone="phone";
    public static final String StudentSemester="semester";
    public SqliteDatabaseHelper(@Nullable Context context) {
        super(context, DatabaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TableName+" ("+StudentId+" integer primary key autoincrement,"+StudentName+" text,"+StudentPhone+" text,"+StudentSemester+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TableName);
        onCreate(db);
    }
}
