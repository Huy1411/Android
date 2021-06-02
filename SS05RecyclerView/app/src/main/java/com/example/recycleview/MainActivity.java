package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contact> listContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //b1 Data source
        initData();

        //b2 Adapter
        ContactAdapter contactAdapter = new ContactAdapter(listContacts, this);

        //b3 Layout Manager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        //RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);

        //b4 Recyclerview
        RecyclerView recyclerView = findViewById(R.id.rvContact);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contactAdapter);
    }

    private void initData(){
        listContacts.add(new Contact("Nguyen Van A", "0966968837", R.drawable.user1));
        listContacts.add(new Contact("Nguyen Van B", "0966968838", R.drawable.user2));
        listContacts.add(new Contact("Nguyen Van C", "0966968839", R.drawable.user3));
        listContacts.add(new Contact("Nguyen Van D", "0966968840", R.drawable.user4));
        listContacts.add(new Contact("Nguyen Van A", "0966968837", R.drawable.user1));
        listContacts.add(new Contact("Nguyen Van B", "0966968838", R.drawable.user2));
        listContacts.add(new Contact("Nguyen Van C", "0966968839", R.drawable.user3));
        listContacts.add(new Contact("Nguyen Van D", "0966968840", R.drawable.user4));
        listContacts.add(new Contact("Nguyen Van A", "0966968837", R.drawable.user1));
        listContacts.add(new Contact("Nguyen Van B", "0966968838", R.drawable.user2));
        listContacts.add(new Contact("Nguyen Van C", "0966968839", R.drawable.user3));
        listContacts.add(new Contact("Nguyen Van D", "0966968840", R.drawable.user4));

    }
}
