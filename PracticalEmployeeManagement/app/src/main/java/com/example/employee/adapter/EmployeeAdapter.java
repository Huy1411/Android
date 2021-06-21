package com.example.employee.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employee.R;
import com.example.employee.entity.Employees;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<Employees> list;


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder hd = (EmployeeHolder) holder;
        Employees employeeEntity = list.get(position);
        hd.tvEmployeeName.setText(employeeEntity.employeename);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder{
        TextView tvEmployeeName;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            tvEmployeeName = (TextView) itemView.findViewById(R.id.tvEmployeeName);
        }
    }
    public EmployeeAdapter(Activity activity, List<Employees> list) {
        this.activity = activity;
        this.list = list;
    }

    public void reloadData(List<Employees> list)
    {
        this.list = list;
        this.notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.activity_list,parent,false);
        EmployeeHolder holder = new EmployeeHolder(itemView);
        return holder;
    }

}
