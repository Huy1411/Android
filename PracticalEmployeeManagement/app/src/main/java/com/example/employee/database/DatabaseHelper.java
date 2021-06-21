package com.example.employee.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.employee.EmployeesDAO;
import com.example.employee.entity.Employees;

@Database(entities = {Employees.class},version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static DatabaseHelper appDatabase;
    public abstract EmployeesDAO employeeDao();

    public static DatabaseHelper getAppDatabase(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context,
                DatabaseHelper.class,"Employees").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
