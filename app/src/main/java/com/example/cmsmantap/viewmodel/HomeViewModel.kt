package com.example.cmsmantap.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cmsmantap.data.CheckerRepository
import com.example.cmsmantap.data.MakerRepository
import com.example.cmsmantap.data.MakerModel
import com.example.cmsmantap.data.ReleaserRepository

class HomeViewModel(application: Application): AndroidViewModel(application){

    private var MakerRepository:MakerRepository?=null
    private var CheckerRepository:CheckerRepository?=null
    private var ReleaserRepository:ReleaserRepository?=null
    var MakerModelListLiveData : LiveData<List<MakerModel>>?=null
    //var CheckerModelListLiveData : LiveData<List<MakerModel>>?=null
    var ReleaserModelListLiveData : LiveData<List<MakerModel>>?=null
    var createPostLiveData:LiveData<MakerModel>?=null
    var deletePostLiveData:LiveData<Boolean>?=null

    init {
        MakerRepository = MakerRepository()
        CheckerRepository = CheckerRepository()
        MakerModelListLiveData = MutableLiveData()
        //CheckerModelListLiveData = MutableLiveData()
        ReleaserModelListLiveData = MutableLiveData()
        createPostLiveData = MutableLiveData()
        deletePostLiveData = MutableLiveData()
    }

    fun fetchAllTransaksiMakerUmum(){
        MakerModelListLiveData = MakerRepository?.fetchAllTransaksiMakerUmum()
    }

    fun fetchAllTransaksiCheckerUmum(){
        MakerModelListLiveData = CheckerRepository?.fetchAllTransaksiCheckerUmum()
    }

    fun fetchAllTransaksiReleaserUmum(){
        ReleaserModelListLiveData = ReleaserRepository?.fetchAllTransaksiReleaserUmum()
    }

}