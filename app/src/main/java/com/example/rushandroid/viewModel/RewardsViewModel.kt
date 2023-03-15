package com.example.rushandroid.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rushandroid.TestData
import com.example.rushandroid.data.entities.RequestRewards

class RewardsViewModel  @ViewModelInject constructor():ViewModel(){

    private val test =  TestData()

    fun getList():MutableLiveData<RequestRewards>{
        return MutableLiveData(test.successRewardsQuery)
    }
}