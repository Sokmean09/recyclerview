package com.example.recyclerview.Networking;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.activities.PropertyActivity;
import com.example.recyclerview.activities.PropertyListActivity;
import com.example.recyclerview.adapters.IOnPropertyItemListener;
import com.example.recyclerview.adapters.PropertyAdapter;
import com.example.recyclerview.databinding.ActivityApiBinding;
import com.example.recyclerview.models.PropertyModel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiActivity extends AppCompatActivity {
    private String apiKey = "reqres_701a7165c26d4dbaada64c86260b3d6d";
    private ActivityApiBinding binding;
    private List<UserModel> userList;
    private Retrofit retrofit;
    private IUserAPIService api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        var logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(IUserAPIService.class);

        binding.rvUserList.setLayoutManager(
                new LinearLayoutManager(this)
        );

        getUserList();

    }

    private void getUserList() {
        api.getUsers(apiKey).enqueue(new Callback<ApiDataModel>() {
            @Override
            public void onResponse(Call<ApiDataModel> call, Response<ApiDataModel> response) {
                if (response.isSuccessful()) {
                    ApiDataModel data = response.body();
                    userList = new ArrayList<>(data.data);

                    var userAdapter = new UserAdapter(userList, new IOnPropertyItemListener() {
                        @Override
                        public void onItemClick(int position) {
                        }
                    });
                    binding.rvUserList.setAdapter(userAdapter);
                }
            }

            @Override
            public void onFailure(Call<ApiDataModel> call, Throwable t) {

            }
        });
    }
}