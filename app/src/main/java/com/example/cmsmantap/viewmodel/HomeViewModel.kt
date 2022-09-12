package com.example.cmsmantap.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cmsmantap.data.MakerRepository
import com.example.cmsmantap.data.MakerModel

class HomeViewModel(application: Application): AndroidViewModel(application){

    private var MakerRepository:MakerRepository?=null
    var MakerModelListLiveData : LiveData<List<MakerModel>>?=null
    var createPostLiveData:LiveData<MakerModel>?=null
    var deletePostLiveData:LiveData<Boolean>?=null

    init {
        MakerRepository = MakerRepository()
        MakerModelListLiveData = MutableLiveData()
        createPostLiveData = MutableLiveData()
        deletePostLiveData = MutableLiveData()
    }

    fun fetchAllTransaksiMakerUmum(){
        MakerModelListLiveData = MakerRepository?.fetchAllTransaksiMakerUmum()
    }

    fun createPost(MakerModel: MakerModel){
        createPostLiveData = MakerRepository?.createPost(MakerModel)
    }

    fun deletePost(id:Int){
        deletePostLiveData = MakerRepository?.deletePost(id)
    }

}