package com.example.rushandroid.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rushandroid.ResponsesStr
import com.example.rushandroid.TestData
import com.example.rushandroid.data.entities.LoginRequest
import com.example.rushandroid.data.entities.LoginResponse
import com.example.rushandroid.data.entities.RegisterRequest
import com.example.rushandroid.data.entities.RequestUser
import com.example.rushandroid.data.repository.LoginRepository
import com.example.rushandroid.utils.Resource
class LoginSignupVIewModel @ViewModelInject constructor(private val repo: LoginRepository):ViewModel() {

    private val testData: TestData = TestData()

    private val _currentPerson: MutableLiveData<RequestUser> =
        MutableLiveData(RequestUser(0,"",null))

    val currentPerson: MutableLiveData<RequestUser> = _currentPerson

    //API
   fun loginUser(mobNum:String,mpin:String,messageOverride:String?=null){
       val req  = LoginRequest(mobNum,mpin)
       val observer = repo.login(req)
       observer.observeForever {res->
           observer.removeObserver { observer }
           when (res.status) {
               Resource.Status.SUCCESS -> {
                   val data = res.data
                   val msg = messageOverride?: ResponsesStr.SuccessLogin.str
                   _currentPerson.value =  RequestUser(data =data, status = 200, message = msg )
               }
               Resource.Status.ERROR -> {
                   val msg = messageOverride?: ResponsesStr.FailedLogin.str
                   _currentPerson.value =  RequestUser(data =null, status = 404, message = msg )
               }
               else->{

               }
           }
       }
   }

    //API
    fun registerUser(mobNum:String,mpin:String,fname:String,lname:String){
        val req = RegisterRequest(fname,lname,mobNum,mpin)
        val observer = repo.register(req)
        observer.observeForever {res->
            observer.removeObserver { observer }
            when (res.status) {
                Resource.Status.SUCCESS -> {
                    loginUser(mobNum,mpin,ResponsesStr.SuccessRegistration.str)
                }
                Resource.Status.ERROR -> {
                    _currentPerson.value =  RequestUser(data =null, status = 404, message = ResponsesStr.FailedRegistration.str )
                }
                else->{
                }
            }
        }
    }
    fun loginTest(mobNum:String,mpin:String){
        if(mobNum == "9123456789" && mpin == "1234" ){
            val user = testData.successUser
            _currentPerson.value = RequestUser(200,ResponsesStr.SuccessLogin.str,user)
        }else{
            _currentPerson.value =  RequestUser(data =null, status = 404, message = ResponsesStr.FailedLogin.str )
        }
    }

    fun registerTest(mobNum:String,mpin:String,fname:String,lname:String){
        if(mobNum == "9123456789" && mpin == "1234" && fname== "Mang" && lname == "Tani" ){
            val user = testData.successUser
            _currentPerson.value = RequestUser(200,ResponsesStr.SuccessLogin.str,user)
        }else{
            _currentPerson.value =  RequestUser(data =null, status = 404, message = ResponsesStr.FailedLogin.str )
        }
    }
}