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


public class DeleteMonthFragment extends Fragment {

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

    @Override
    public void onResume() {
        super.onResume();

        sqliteDatabaseHelper=new SqliteDatabaseHelper(getContext());
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
                                CheckingForNewMonth=getContext().getSharedPreferences("CheckingMonth",Context.MODE_PRIVATE);
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
                        Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
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
        return view;
    }

}
