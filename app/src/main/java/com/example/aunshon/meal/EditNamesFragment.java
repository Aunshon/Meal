package com.example.aunshon.meal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


public class EditNamesFragment extends Fragment {

    SharedPreferences CheckingForNewMonth,memberinput;
    SharedPreferences.Editor editor,member_saving_to_sharedprefrences;
    EditText m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,monthinput,yearinput;
    Button savebtn;

    public EditNamesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_edit_names, container, false);
        m1=view.findViewById(R.id.m1);m2=view.findViewById(R.id.m2);m3=view.findViewById(R.id.m3);m4=view.findViewById(R.id.m4);
        m5=view.findViewById(R.id.m5);m6=view.findViewById(R.id.m6);m7=view.findViewById(R.id.m7);m8=view.findViewById(R.id.m8);
        m9=view.findViewById(R.id.m9);m10=view.findViewById(R.id.m10);savebtn=view.findViewById(R.id.savebtn);

        try{
            memberinput=getContext().getSharedPreferences("Member",MODE_PRIVATE);
            member_saving_to_sharedprefrences=memberinput.edit();
            m1.setText(memberinput.getString("m1","Member1"));m6.setText(memberinput.getString("m6","Member6"));
            m2.setText(memberinput.getString("m2","Member2"));m7.setText(memberinput.getString("m7","Member7"));
            m3.setText(memberinput.getString("m3","Member3"));m8.setText(memberinput.getString("m8","Member8"));
            m4.setText(memberinput.getString("m4","Member4"));m9.setText(memberinput.getString("m9","Member9"));
            m5.setText(memberinput.getString("m5","Member5"));m10.setText(memberinput.getString("m10","Member10"));
        }catch (Exception e){
            Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member_saving_to_sharedprefrences.putString("m1",m1.getText().toString());
                member_saving_to_sharedprefrences.putString("m2",m2.getText().toString());
                member_saving_to_sharedprefrences.putString("m3",m3.getText().toString());
                member_saving_to_sharedprefrences.putString("m4",m4.getText().toString());
                member_saving_to_sharedprefrences.putString("m5",m5.getText().toString());
                member_saving_to_sharedprefrences.putString("m6",m6.getText().toString());
                member_saving_to_sharedprefrences.putString("m7",m7.getText().toString());
                member_saving_to_sharedprefrences.putString("m8",m8.getText().toString());
                member_saving_to_sharedprefrences.putString("m9",m9.getText().toString());
                member_saving_to_sharedprefrences.putString("m10",m10.getText().toString());
                member_saving_to_sharedprefrences.apply();
                member_saving_to_sharedprefrences.commit();
                Toast.makeText(getContext(), "Name Changed", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
