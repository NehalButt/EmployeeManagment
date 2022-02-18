package com.example.employeemanagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class Employee_Details_Activity extends AppCompatActivity {
    EditText Empname , Salary;
    Spinner empdepartment;
    Button save;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        Empname = (EditText) findViewById(R.id.empname);
        Salary = (EditText) findViewById(R.id.salary);
        empdepartment = (Spinner) findViewById(R.id.employeeDepartment);
        save = (Button) findViewById(R.id.savedetails);
        dbhelper = new Dbhelper(this);
        List<String> record = dbhelper.fetchdata();

        ArrayAdapter<String> myadapter = new ArrayAdapter<>(this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item , record);
        myadapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        empdepartment.setAdapter(myadapter);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empname = Empname.getText().toString();
                int salary = Integer.parseInt(Salary.getText().toString());
               int departmentid = (int) empdepartment.getSelectedItemId();

               dbhelper.employeedetailinsert(empname , salary , departmentid);
                Intent i = new Intent(Employee_Details_Activity.this , Employee_name.class);
                startActivity(i);




            }
        });
    }
}