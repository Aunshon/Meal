package com.example.aunshon.meal;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;


public class DeleteMonthFragment extends Fragment {

    public static final String DatabaseName="Meal_Android.db";
    SharedPreferences VersionShare,Chander;
    SharedPreferences.Editor VersionEdit,ChanderEdit;
    Button deletebtn;
    Spinner spinner;
    public static SqliteDatabaseHelper sqliteDatabaseHelper=null;
    public  static SQLiteDatabase setupDB=null;

    Calendar cal=Calendar.getInstance();
    SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
    String month_name = month_date.format(cal.getTime());
    int year = cal.get(Calendar.YEAR);
    String TABLE_NAME=month_name+year;
    EditText yeatinputtext;
    SharedPreferences CheckingForNewMonth,memberinput;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences;
    int versionint;

    @Override
    public void onResume() {
        super.onResume();

        versionint=VersionShare.getInt("Version",1);
        Toast.makeText(getContext(), "Version"+versionint, Toast.LENGTH_SHORT).show();
        sqliteDatabaseHelper=new SqliteDatabaseHelper(getContext(),DatabaseName,null,versionint);

        setupDB=sqliteDatabaseHelper.getWritableDatabase();

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(getContext(),R.array.Spinner_item,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem().toString().equals("Select a month") || yeatinputtext.getText().toString().equals("")){
                    Toast.makeText(getContext(), "select a month and write the year", Toast.LENGTH_SHORT).show();
                }
                else {
                    String spinnertext=spinner.getSelectedItem().toString();
                    String y=yeatinputtext.getText().toString();
                    final String result=spinnertext+y;

                    if (TABLE_NAME.equals(result)){
                        AlertDialog.Builder alertdialog=new AlertDialog.Builder(getContext());
                        alertdialog.setTitle("Are you sure ?");
                        alertdialog.setMessage("you want to delete current month ? if you do this your current month data will lose. Press Yes to delete");
                        alertdialog.setCancelable(true);
                        alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setupDB.rawQuery("drop table if exists "+result,null);
                                setupDB.rawQuery("create table "+TABLE_NAME+" (m1 double,m2 double,m3 double,m4 double,m5 double,m6 double,m7 double,m8 double,m9 double,m10 double,m1m double,m2m double,m3m double,m4m double,m5m double,m6m double,m7m double,m8m double,m9m double,m10m double,expence double)",null);
                                CheckingForNewMonth=getContext().getSharedPreferences("CheckingMonth",MODE_PRIVATE);
                                editor=CheckingForNewMonth.edit();
                                editor.putBoolean("checkmonth",true);
                                editor.apply();
                                editor.commit();
                                Toast.makeText(getContext(), "Month Deleted", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getContext(),MainActivity.class);
                                startActivity(intent);
                            }
                        });
                        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertdialog.show();
                    }
                    else{
                        setupDB.rawQuery("drop table if exists "+result,null);
                        Toast.makeText(getContext(), "Month Deleted 😍", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), ""+versionint, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public DeleteMonthFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_delete_month, container, false);
        spinner=view.findViewById(R.id.spinner);
        deletebtn=view.findViewById(R.id.deletemonthBTN);
        yeatinputtext=view.findViewById(R.id.year_input_text);

        VersionShare=getContext().getSharedPreferences("VersionShareGlobal",MODE_PRIVATE);
        VersionEdit=VersionShare.edit();
        Chander=getContext().getSharedPreferences("truefalse",MODE_PRIVATE);
        ChanderEdit=Chander.edit();
        return view;
    }

}
