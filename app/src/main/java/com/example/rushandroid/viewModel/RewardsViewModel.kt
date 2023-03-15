package com.example.rushandroid.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rushandroid.TestData
import com.example.rushandroid.data.entities.RequestRewards
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class RewardsViewModel  @ViewModelInject constructor():ViewModel(){

    private val test =  TestData()

    fun getList():MutableLiveData<RequestRewards>{
        return MutableLiveData(test.successRewardsQuery)
    }
}