package com.example.cmsmantap.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cmsmantap.network.ApiClient
import com.example.cmsmantap.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReleaserRepository {

    private var apiInterface:ApiInterface?=null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun fetchAllTransaksiReleaserUmum():LiveData<List<MakerModel>>{
        val data = MutableLiveData<List<MakerModel>>()
        Log.d("DEBUG Test", "HERE")

        apiInterface?.fetchAllTransaksiReleaserUmum()?.enqueue(object : Callback<List<MakerModel>>{

            override fun onFailure(call: Call<List<MakerModel>>, t: Throwable) {
                data.value = null
                Log.d("DEBUG FAIL", "HERE")
            }

            override fun onResponse(
                call: Call<List<MakerModel>>,
                response: Response<List<MakerModel>>
            ) {
                val res = response.body()
                Log.d("DEBUG SUCCESS", res.toString())

                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }

            }
        })
        return data
    }

    fun updateTransaksiReleaser(MakerModel: MakerModel):LiveData<MakerModel>{
        val data = MutableLiveData<MakerModel>()

        apiInterface?.updateTransaksiReleaser(MakerModel)?.enqueue(object : Callback<MakerModel>{
            override fun onFailure(call: Call<MakerModel>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<MakerModel>, response: Response<MakerModel>) {
                val res = response.body()
                if (response.code() == 200 && res!=null){
                    data.value = res
                }else{
                    data.value = null
                }
            }
        })

        return data
    }

}