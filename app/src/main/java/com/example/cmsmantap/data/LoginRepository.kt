package com.example.cmsmantap.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cmsmantap.network.ApiClient
import com.example.cmsmantap.network.ApiInterface
import com.example.cmsmantap.response.LoginResponse
import com.example.cmsmantap.response.Wrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {

    private var apiInterface:ApiInterface?=null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    fun login(loginModel: LoginModel):LiveData<Wrapper<LoginResponse>>{
        val data = MutableLiveData<Wrapper<LoginResponse>>()

        apiInterface?.login(loginModel)?.enqueue(object : Callback<Wrapper<LoginResponse>>{
            override fun onFailure(call: Call<Wrapper<LoginResponse>>, t: Throwable) {
                Log.d("DEBUG LoginRepo Error", "Error")
            }

            override fun onResponse(
                call: Call<Wrapper<LoginResponse>>,
                response: Response<Wrapper<LoginResponse>>
            ) {
                val res = response.body()
                Log.d("DEBUG LoginRepo", res.toString())
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