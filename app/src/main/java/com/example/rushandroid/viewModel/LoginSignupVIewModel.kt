package com.example.rushandroid.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rushandroid.data.entities.RequestUser
import com.example.rushandroid.data.entities.Users
import com.example.rushandroid.data.repository.LoginRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers


class LoginSignupVIewModel @ViewModelInject constructor(private val repo: LoginRepository):ViewModel() {

    private val _currentPerson: MutableLiveData<RequestUser> =
        MutableLiveData(RequestUser(0,"",null))

    val currentPerson: MutableLiveData<RequestUser> = _currentPerson

   fun loginUser(mobNum:String,mpin:String){
    repo.processLogin(mobNum,mpin).subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe { userProfile: RequestUser?, throwable: Throwable? ->
               _currentPerson.value = userProfile
           }
   }

    fun registerUser(mobNum:String,mpin:String,fname:String,lname:String){

        val user = Users(fname,lname,mobNum,mpin)
        val request= RequestUser(0,"",user)
        repo.processRegistration(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ userProfile: RequestUser?, throwable: Throwable? ->
            _currentPerson.value = userProfile
        }
    }
}