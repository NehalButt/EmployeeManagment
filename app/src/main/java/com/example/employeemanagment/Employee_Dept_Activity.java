package com.example.employeemanagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Employee_Dept_Activity extends AppCompatActivity {
    EditText Department , Noofemployee;
    Button AddDepartment;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dept);

        Department = (EditText) findViewById(R.id.Department);
        Noofemployee = (EditText) findViewById(R.id.Noofemployee);
        AddDepartment = (Button) findViewById(R.id.AddDepartment);
        dbhelper = new Dbhelper(this);


        AddDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String departmentname = Department.getText().toString();
              int noofemployee = Integer.parseInt(Noofemployee.getText().toString());

              dbhelper.employeeinsert(departmentname , noofemployee);
              Toast.makeText(Employee_Dept_Activity.this, "data inserted", Toast.LENGTH_SHORT).show();
              Intent i = new Intent(Employee_Dept_Activity.this , Employee_Details_Activity.class);
              startActivity(i);
            }
        });

    }
}