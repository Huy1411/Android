package com.example.employee.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Employee")
public class Employees {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "employeename")
    public String employeename;

    @ColumnInfo(name = "designation")
    public String designation;

    @ColumnInfo(name = "salary")
    public String salary;
}
