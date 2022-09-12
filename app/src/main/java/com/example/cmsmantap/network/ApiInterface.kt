package com.example.cmsmantap.network

import com.example.cmsmantap.data.MakerModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("daftar_transaksi_maker_umum")
    fun fetchAllTransaksiMakerUmum(): Call<List<MakerModel>>

    @POST("posts")
    fun createPost(@Body MakerModel: MakerModel):Call<MakerModel>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id:Int):Call<String>

}