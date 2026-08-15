package com.example.recyclerview.Networking;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    int id;
    String email;
    @SerializedName("first_name")

    String firstName;
    @SerializedName("last_name")

    String lastName;
    String avatar;
}
