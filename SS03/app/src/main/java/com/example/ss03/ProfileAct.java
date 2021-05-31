package com.example.ss03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfileAct extends AppCompatActivity implements View.OnClickListener {

    private Button btnDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d("TAG" , "onCreate on Profile");

        btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        Intent intent = getIntent();
        String userName = intent.getStringExtra(Constant.USER);
        int age = intent.getIntExtra("AGE" , 0);

        Log.d("TAG", userName);
        Log.d("TAG", age+"");

        Toast.makeText(this,userName, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDone:
                onDone();
                break;
            default:
                break;
        }

    }

    private void onDone(){
        Intent intent = new Intent();
        intent.putExtra("PROFILE ", "TEXT YOUR PROFILE ");
        setResult(Constant.RESULTCODE,intent);
        finish();
    }


}
