package com.example.json;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("5TP")
    Call<ArrayList<UserData>> getAllUsers();
}
