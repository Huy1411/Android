package com.example.employee;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.employee.entity.Employees;

import static androidx.room.OnConflictStrategy.REPLACE;


import java.util.List;

@Dao
public interface EmployeesDAO {
    @Insert(onConflict = REPLACE)
    void insertEmployee(Employees employeeEntity);

    @Update
    void updateEmployee(Employees employeeEntity);

    @Delete
    void deleteEmployee(Employees employeeEntity);

    @Query("SELECT * FROM Employee")
    List<Employees> getAllBookmark();

    @Query("SELECT * FROM Employee WHERE id = :id")
    Employees getBookmark(int id);

    @Query("DELETE  FROM Employee")
    void deleteAll();

}
