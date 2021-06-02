package com.example.recycleview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter {
    private List<Contact> listContacts;

    private Activity activity;

    public ContactAdapter(List<Contact> listContacts, Activity activity) {
        this.listContacts = listContacts;
        this.activity = activity;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_contact, parent, false);
        ContactHolder contactHolder = new ContactHolder(view);
        return contactHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerView.ViewHolder holder, int position) {
        ContactHolder contactHolder = (ContactHolder) holder;
        Contact data = listContacts.get(position);
        contactHolder.ivAvatar.setImageResource(data.getAvatar());
        contactHolder.tvName.setText(data.getName());
        contactHolder.tvPhone.setText(data.getPhone());
    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }

    private class ContactHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvName;
        TextView tvPhone;

        public ContactHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvName = itemView.findViewById(R.id.tvUser);
            tvPhone = itemView.findViewById(R.id.tvPhone);
        }
    }
}
