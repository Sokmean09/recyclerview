package com.example.recyclerview.Networking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface IUserAPIService {
    @GET("users")
    Call<ApiDataModel> getUsers(@Header("x-api-key") String apiKey);

}
