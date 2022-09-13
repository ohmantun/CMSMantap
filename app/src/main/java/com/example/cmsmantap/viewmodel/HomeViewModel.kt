package com.example.cmsmantap.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cmsmantap.data.*
import com.example.cmsmantap.response.LoginResponse
import com.example.cmsmantap.response.Wrapper

class HomeViewModel(application: Application): AndroidViewModel(application){

    private var MakerRepository:MakerRepository?=null
    private var CheckerRepository:CheckerRepository?=null
    private var ReleaserRepository:ReleaserRepository?=null
    private var LoginRepository:LoginRepository?=null

    var MakerModelListLiveData : LiveData<List<MakerModel>>?=null
    // var CheckerModelListLiveData : LiveData<List<MakerModel>>?=null

    var ReleaserModelListLiveData : LiveData<List<MakerModel>>?=null
    var loginLiveData : LiveData<Wrapper<LoginResponse>>?=null


    var createPostLiveData:LiveData<MakerModel>?=null
    var deletePostLiveData:LiveData<Boolean>?=null

    // create payroll
    var createTransaksiMakerLiveData:LiveData<MakerModel>?=null




    init {
        MakerRepository = MakerRepository()
        CheckerRepository = CheckerRepository()
        ReleaserRepository = ReleaserRepository()
        MakerModelListLiveData = MutableLiveData()
        LoginRepository = LoginRepository()
        //CheckerModelListLiveData = MutableLiveData()
        ReleaserModelListLiveData = MutableLiveData()
        createPostLiveData = MutableLiveData()
        deletePostLiveData = MutableLiveData()

        loginLiveData = MutableLiveData()
        createTransaksiMakerLiveData = MutableLiveData()
    }

    fun fetchAllTransaksiMakerUmum(){
        MakerModelListLiveData = MakerRepository?.fetchAllTransaksiMakerUmum()
    }

    fun fetchAllTransaksiCheckerUmum(){
        MakerModelListLiveData = CheckerRepository?.fetchAllTransaksiCheckerUmum()
    }

    fun fetchAllTransaksiReleaserUmum(){
        ReleaserModelListLiveData = ReleaserRepository?.fetchAllTransaksiReleaserUmum()
        Log.d("DEBUG vm releaser", ReleaserModelListLiveData.toString())
    }

    fun login(loginModel: LoginModel){
        loginLiveData = LoginRepository?.login(loginModel)
        Log.d("DEBUG vm", loginModel.toString())
    }

    fun createTransaksiMaker(makerModel: MakerModel){
        createTransaksiMakerLiveData = MakerRepository?.createTransaksiMaker(makerModel)
    }

}