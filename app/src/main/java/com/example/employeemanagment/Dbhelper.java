package com.example.employeemanagment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Dbhelper extends SQLiteOpenHelper {
    String dbname = "Employee.dp";
    public Dbhelper(@Nullable Context context) {
        super(context, "Employee.dp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL("Create table employee(Id integer primary key autoincrement , Department text , NoofEmployee integer)");
       sqLiteDatabase.execSQL("Create table employeedetail(Id integer primary key autoincrement , Empname text , Salary integer , departmentid integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("Drop Table if Exists employee");
    sqLiteDatabase.execSQL("Drop Table if Exists employeedetail");
    }
    public void employeeinsert(String Departmentname , int Noofemployee){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues insert = new ContentValues();
        insert.put("Department" ,Departmentname);
        insert.put("NoofEmployee" ,Noofemployee);
        db.insert("employee" , null , insert);
    }
    public void employeedetailinsert(String empname , int salary , int depid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues insert = new ContentValues();
        insert.put("Empname" ,empname);
        insert.put("Salary" ,salary);
        insert.put("departmentid" ,depid);
        db.insert("employeedetail" , null , insert);
    }
    public List<String> fetchdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("select * from employee" , null);
        List<String> tablerecord = new ArrayList<>();
        while (find.moveToNext()){
            tablerecord.add(find.getString(1));
        }
        return tablerecord;
    }
    public List<String> fetchdata2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("select * from employeedetail" , null);
        List<String> tablerecord = new ArrayList<>();
        while (find.moveToNext()){
            tablerecord.add(find.getString(1));
        }
        return tablerecord;
    }
}
