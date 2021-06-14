package com.example.weathernetwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.weathernetwork.adapter.HourAdapter;
import com.example.weathernetwork.model.Weather;
import com.example.weathernetwork.network.APIManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHour;
    private TextView tvTemp;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTemp = (TextView)findViewById(R.id.tvTemp);
        tvStatus = (TextView)findViewById(R.id.tvStatus);

        //B1
        getHours();
        //B2
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        //B3
        //B4
        rvHour= (RecyclerView)findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);
    }

    private void getHours(){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(APIManager.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        APIManager service = retrofit.create(APIManager.class);
        service.getHour().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if(response.body()==null) return;
                List<Weather> listWeather = response.body();
                HourAdapter adapter = new HourAdapter(MainActivity.this,listWeather);
                rvHour.setAdapter(adapter);
                Weather weather = listWeather.get(0);
                tvTemp.setText(weather.getTemperature().getValue().intValue()+"0");
                tvStatus.setText(weather.getIconPhrase());
            }
            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
            }
        });
    }
}
