package com.example.rushandroid.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rushandroid.TestData
import com.example.rushandroid.data.entities.RequestRewards
import com.example.rushandroid.data.entities.Rewards
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RewardsViewModel  @ViewModelInject constructor():ViewModel(){

    private val test =  TestData()

    val latestRewards: Flow<List<Rewards>> = flow {
        val list = test.successRewardsQuery.list?.let { ArrayList(it) }
        val latestNews = list?: arrayListOf()
        emit(latestNews)
        delay(100)
    }
}