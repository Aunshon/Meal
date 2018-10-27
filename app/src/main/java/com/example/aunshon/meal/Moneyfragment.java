package com.example.aunshon.meal;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Moneyfragment extends Fragment {

    SharedPreferences CheckingForNewMonth,memberinput;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences;
    TextView month,m1T,m2T,m3T,m4T,m5T,m6T,m7T,m8T,m9T,m10T;

    public Moneyfragment() {
        // Required empty public constructor
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

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());
        int year = cal.get(Calendar.YEAR);
        String TABLE_NAME="Accounce of "+month_name+" "+year;
        month.setText(TABLE_NAME);
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
