package com.example.recyclerviewintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerviewintent.adapter.ContactAdapter;
import com.example.recyclerviewintent.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactAdapter.IOnClickAdapter {
    List<Contact> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 1: Data source
        initData();

        //Step 2: Adapter
        ContactAdapter adapter = new ContactAdapter(this,list);

        //Step 7: Start register event(Onclick)
        adapter.registerClick(this);

        //Step 3: Layout Manager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        //Step 4: RecycleView
        RecyclerView rvContact = findViewById(R.id.rvContact);
        rvContact.setLayoutManager(layoutManager);
        rvContact.setAdapter(adapter);
    }

    private void initData(){
        //Seeding data
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user1));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user2));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user3));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user4));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user1));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user2));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user3));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user4));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user1));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user2));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user3));
        list.add(new Contact("Nguyen Van A", "0123456789",R.drawable.user4));

    }
    private void goToDetail(String name){
        Intent intent = new Intent (this, DetailActivity.class);
        intent.putExtra("NAME", name);
        startActivity(intent);
    }

    //Step 6.1
    @Override
    public void onClickItem(int position) {
        Contact model = list.get(position);
        goToDetail(model.getName());
    }

    //Step 6.2
    @Override
    public void onClickEdit(int position) {
        Contact model = list.get(position);
        goToDetail(model.getName());

    }
}
