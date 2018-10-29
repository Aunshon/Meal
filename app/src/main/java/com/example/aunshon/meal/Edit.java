package com.example.aunshon.meal;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

       try{
           EditNamesFragment editNamesFragment=new EditNamesFragment();
           FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.EditFragmentContainer,editNamesFragment,"editNamesFragment");
           fragmentTransaction.commit();
       }catch (Exception e){
           Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
       }
    }

    public void edit_neme_btn(View view) {
        EditNamesFragment editNamesFragment=new EditNamesFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.EditFragmentContainer,editNamesFragment,"editNamesFragment");
        fragmentTransaction.commit();
    }

    public void delete_month_accoount(View view) {
        DeleteMonthFragment deleteMonthFragment=new DeleteMonthFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.EditFragmentContainer,deleteMonthFragment,"deleteMonthFragment");
        fragmentTransaction.commit();
    }
}
