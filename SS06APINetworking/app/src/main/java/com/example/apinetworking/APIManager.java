package com.example.apinetworking;


import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

public interface APIManager {
    String SERVER_URL = "https://api-demo-anhth.herokuapp.com";


    @GET("/data.json")
    Call<Item> getItemData();

    @GET("/datas.json")
    Call<List<Item>> getListData();

}
