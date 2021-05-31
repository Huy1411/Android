package com.example.ss03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvHello;
    private static final int REQUESTCODE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "onCreate()");

        Button btnClick = (Button) findViewById(R.id.btnClick);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        tvHello  = (TextView) findViewById(R.id.tvHello);
        tvHello.setText("Chào các bạn");

        btnClick.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUESTCODE){
            if (requestCode == Constant.RESULTCODE){
                String text = data.getStringExtra("Profile");
                tvHello.setText(text);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnClick:
                Log.d("TAG" , "onClick onClick !!!");
                Intent intent = new Intent(MainActivity.this, ProfileAct.class);
                intent.putExtra(Constant.USER, tvHello.getText().toString());
                intent.putExtra("Age", 30);
                startActivityForResult(intent,REQUESTCODE);
                break;
            case R.id.btnCancel:
                Log.d("TAG" , "Cancel clicked !!!");
                tvHello.setText("Cancel");
                break;
            default:
                break;
        }
    }
}
