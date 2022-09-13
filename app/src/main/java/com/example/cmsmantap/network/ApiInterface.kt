package com.example.cmsmantap.network

import com.example.cmsmantap.data.LoginModel
import com.example.cmsmantap.data.MakerModel
import com.example.cmsmantap.response.LoginResponse
import com.example.cmsmantap.response.Wrapper
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("daftar_transaksi_maker_umum")
    fun fetchAllTransaksiMakerUmum(): Call<List<MakerModel>>

    @GET("daftar_transaksi_checker_umum")
    fun fetchAllTransaksiCheckerUmum(): Call<List<MakerModel>>

    @GET("daftar_transaksi_releaser_umum")
    fun fetchAllTransaksiReleaserUmum(): Call<List<MakerModel>>

    @POST("save_transaksi_maker_umum")
    fun createTransaksiMaker(@Body MakerModel: MakerModel):Call<MakerModel>

    @POST("login")
    fun login(@Body LoginModel: LoginModel):Call<Wrapper<LoginResponse>>

//    @DELETE("posts/{id}")
//    fun deletePost(@Path("id") id:Int):Call<String>

}