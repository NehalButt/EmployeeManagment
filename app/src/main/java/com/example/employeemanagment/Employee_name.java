package com.example.employeemanagment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class Employee_name extends AppCompatActivity {
    ListView mylist;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_name);

        mylist = (ListView) findViewById(R.id.mylist);
        dbhelper = new Dbhelper(this);
        List<String> record = dbhelper.fetchdata2();
        ArrayAdapter<String> myadapter = new ArrayAdapter<>(this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item , record);
        mylist.setAdapter(myadapter);
    }
}