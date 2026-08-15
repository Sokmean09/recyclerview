package com.example.recyclerview.Networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiDataModel {
    int page;
    @SerializedName("per_page")
    int perPage;
    int total;
    @SerializedName("total_pages")

    int totalPages;
    List<UserModel> data;
}
