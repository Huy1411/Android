package com.example.ss01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    TextView tvTilte;
    EditText edUser;
    ImageView ivCover;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        tvTilte = findViewById(R.id.tvtitle);

        ivCover = findViewById(R.id.ivCover);
        ivCover.setImageResource(R.drawable.baby);

        edUser = findViewById(R.id.edUser);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                Log.d("MainActivity", edUser.getText().toString());
                tvTilte.setText("Hello T1907M");
                Toast.makeText(MainActivity.this, edUser.getText().toString(), Toast.LENGTH_SHORT).show();
            case R.id.tvtitle:
                break;
            default:
                break;
        }

    }
}
