package com.example.networkweather;

import android.content.ClipData;

import com.example.networkweather.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class APIManager {

    String SERVER_URL ="http://dataservice.accuweather.com/";

    @GET("forecasts/v1/hourly/12hour/353412?apikey=93Qg780lHwYM4SO58n7DFPLqHg4oKADn&language=vi-vn&metric=true")
    Call<Weather> getHour();

    @GET("forecasts/v1/daily/5day/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Weather>> getDay();
}
