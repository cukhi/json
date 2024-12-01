package com.example.json;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    private RecyclerView courseRV;
    private ArrayList<UserData> userDataArrayList;
    private UserDataViewAdapter userDataViewAdapter;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        courseRV = findViewById(R.id.idRVCourse);
        userDataArrayList = new ArrayList<>();

        Log.d("Initialization", "RecyclerView initialized: " + (courseRV != null));
        getAllUsers();

    }
    private void getAllUsers() {
        Log.d("getAllUsers", "API Call initiated");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "http://json.itmargen.com/5TP/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<ArrayList<UserData>> call = retrofitAPI.getAllUsers();


        call.enqueue(new Callback<ArrayList<UserData>>() {
            @Override
            public void onResponse(Call<ArrayList<UserData>> call, Response<ArrayList<UserData>> response) {
                Log.d("getAllUsers", "API Call success");
                if(response.isSuccessful() && response.body() != null){
                    userDataArrayList = response.body();
                    Log.d("getAllUsers", "Raw response: " + response.toString());
                    Log.d("getAllUsers", "Error body: " + response.errorBody());



                        userDataViewAdapter = new UserDataViewAdapter(userDataArrayList,MainActivity.this);
                        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                        courseRV.setLayoutManager(manager);
                        courseRV.setAdapter(userDataViewAdapter);

            }else{
                    Log.e("getAllUsers", "Response is not successful or is null");
                }

        }

                         @Override
                         public void onFailure(Call<ArrayList<UserData>> call, Throwable throwable) {
                             Toast.makeText(MainActivity.this, "Fail to get data", Toast.LENGTH_SHORT).show();
                             Log.d("TAG", "onFailure: " + "Failed to get data");
                         };
    });


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.idRVCourse), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

}

