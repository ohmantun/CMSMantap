package com.example.cmsmantap.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("created_at")
    val created_at: Any,
    @Expose
    @SerializedName("email")
    val email: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("institusi_id")
    val institusi_id: String,
    @Expose
    @SerializedName("nama")
    val nama: String,
    @Expose
    @SerializedName("no_handphone")
    val no_handphone: String,
    @Expose
    @SerializedName("profile_photo_url")
    val profile_photo_url: String,
    @Expose
    @SerializedName("role_id")
    val role_id: Int,
    @Expose
    @SerializedName("status")
    val status: Any,
    @Expose
    @SerializedName("two_factor_confirmed_at")
    val two_factor_confirmed_at: Any,
    @Expose
    @SerializedName("updated_at")
    val updated_at: Any,
    @Expose
    @SerializedName("username")
    val username: String
)