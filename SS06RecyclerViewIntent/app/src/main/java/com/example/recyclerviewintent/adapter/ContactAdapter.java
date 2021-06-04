package com.example.recyclerviewintent.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewintent.R;
import com.example.recyclerviewintent.model.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter {

    // 1. Data source

    // 2. Layout

    Activity activity;
    List<Contact> listContact;

    public ContactAdapter(Activity activity, List<Contact> listContact) {
        this.activity = activity;
        this.listContact = listContact;
    }

    //Step 2
    IOnClickAdapter iOnClickAdapter;

    //Step 3
    public void registerClick(IOnClickAdapter iClick){
        this.iOnClickAdapter= iClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //B1
        View itemView = activity.getLayoutInflater().inflate(R.layout.icon_contact, parent,false);
        ContactHolder holder = new ContactHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //B2
        ContactHolder vh = (ContactHolder) holder;
        Contact model = listContact.get(position);
        vh.ivAvatar.setImageResource(model.getAvatar());
        vh.tvUser.setText(model.getName());
        vh.tvPhone.setText(model.getPhone());

    }

    @Override
    public int getItemCount() {
        return listContact.size();
    }
    public class ContactHolder extends RecyclerView.ViewHolder{
        private ImageView ivAvatar;
        private TextView tvUser;
        private TextView tvPhone;
        private Button btEdit;


        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            btEdit = itemView.findViewById(R.id.btEdit);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Tag ", "onClick : "+getAdapterPosition());
                    Contact model = listContact.get(getAdapterPosition());
                    Log.d("Contact Adapter ", "name" + model.getName());

                    //Step 4
                    iOnClickAdapter.onClickItem(getAdapterPosition());
                }
            });

            btEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnClickAdapter.onClickEdit(getAdapterPosition());
                }
            });
        }
    }

    //Ster 1: Create interface contains (actions)
    public interface IOnClickAdapter{
        void onClickItem(int position);
        void onClickEdit(int position);
    }
}
