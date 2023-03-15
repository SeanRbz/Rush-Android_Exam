package com.example.rushandroid.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rushandroid.ResponsesStr
import com.example.rushandroid.TestData
import com.example.rushandroid.data.entities.LoginRequest
import com.example.rushandroid.data.entities.RegisterRequest
import com.example.rushandroid.data.entities.RequestUser
import com.example.rushandroid.data.repository.LoginRepository
import com.example.rushandroid.utils.Resource
import java.util.regex.Pattern

class LoginSignupVIewModel @ViewModelInject constructor(private val repo: LoginRepository):ViewModel() {

    private val testData: TestData = TestData()

    private val digitRegexPattern = Pattern.compile("^(\\+\\d{1,2}\\s?)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}\$")

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

    fun validatePtn(ptn:String):Pair<String,Boolean>{
        return if (ptn.isEmpty()) {
            Pair("Empty Phone",false)
        }else if (ptn.length<=9) {
            Pair("Phone number too short it must be atleast 9 characters",false)
        } else if (!digitRegexPattern.matcher(ptn).find()) {
            Pair("Not a valid phone number",false)
        }else{
            Pair("",true)
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

    fun resetData(){
        _currentPerson.value = testData.resetRequestUser
    }
}