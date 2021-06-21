package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employee.R;
import com.example.employee.adapter.EmployeeAdapter;
import com.example.employee.database.DatabaseHelper;
import com.example.employee.entity.Employees;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btAdd, btUpdate, btDelete;
    EditText edEmployeeName, edDesignation, edSalary;
    DatabaseHelper db;
    EmployeeAdapter employeeAdapter;
    RecyclerView recyclerView;
    List<Employees> listEmp = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edEmployeeName = findViewById(R.id.edEmployeeName);
        edDesignation = findViewById(R.id.edDesignation);
        edSalary = findViewById(R.id.edSalary);
        btAdd = findViewById(R.id.add);
        btUpdate = findViewById(R.id.update);
        btDelete = findViewById(R.id.delete);
        btAdd.setOnClickListener(this::onClick);
        btUpdate.setOnClickListener(this::onClick);
        btDelete.setOnClickListener(this::onClick);
        initData();
        getAllEmployee();
        employeeAdapter = new EmployeeAdapter(MainActivity.this,listEmp);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView = findViewById(R.id.rcListEmployee);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(employeeAdapter);

        db = DatabaseHelper.getAppDatabase(this);

    }
    public void initData()
    {
        Employees employeeEntity = new Employees();
        employeeEntity.employeename = "nguyen van a";
        employeeEntity.designation = "demo";
        employeeEntity.salary = "10000";
        db.employeeDao().insertEmployee(employeeEntity);
    }

    private void updateEmployee(int id){
        Employees em = db.employeeDao().getBookmark(id);
        em.employeename = edEmployeeName.getText().toString();
        em.designation = edEmployeeName.getText().toString();
        em.salary = edSalary.getText().toString();
        db.employeeDao().updateEmployee(em);
    }
    private void deleteEmployee(int id){
        Employees em = db.employeeDao().getBookmark(id);
        db.employeeDao().deleteEmployee(em);
    }
    private void findEmployee(int id){
        Employees em = db.employeeDao().getBookmark(id);
    }
    private void getAllEmployee()
    {
        if (db.employeeDao().getAllBookmark()!=null)
        {
            listEmp = db.employeeDao().getAllBookmark();
            employeeAdapter.reloadData(listEmp);
        }else{
            listEmp = db.employeeDao().getAllBookmark();
        }

    }
    private void insertEmployee()
    {
        Employees em = new Employees();
        em.employeename = edEmployeeName.getText().toString();
        em.designation = edEmployeeName.getText().toString();
        em.salary = edSalary.getText().toString();
        db.employeeDao().insertEmployee(em);

    }


    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.add:
                insertEmployee();
                Toast.makeText(this, "Insert success", Toast.LENGTH_LONG).show();
                break;
            case R.id.update:
                break;
            case R.id.delete:
                break;
            default:
                break;
        }
    }
}
