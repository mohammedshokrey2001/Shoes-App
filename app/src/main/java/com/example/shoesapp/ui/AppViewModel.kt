package com.example.shoesapp.ui

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoesapp.model.ShoeModel


class AppViewModel : ViewModel() {

     private val loginState =  MutableLiveData<Boolean>()
    private val sessionState =  MutableLiveData<Boolean>()

    private val email = MutableLiveData<String>()
     private val password = MutableLiveData<String>()

     val shoeLit = MutableLiveData<MutableList<ShoeModel>>()




    init {
        loginState.value = false
        email.value = "mohamed@mail.com"
        password.value = "m1234"
        shoeLit.value = ArrayList()
        sessionState.value = false


    }

    fun getLogInState(): Boolean {
        return loginState.value!!
    }


    fun login(mail:String,pass:String):Boolean{

        if (mail == email.value.toString() && pass == password.value.toString()){
            loginState.value = true
            Log.i("app view model", "login: login success")
            return true
        }
        return false
    }


    fun startSession(){
        sessionState.value = true
    }

    fun  logout(){
        loginState.value=false
    }

    fun endSession(){
        sessionState.value = false
    }

    fun getSessionState():Boolean{
        return sessionState.value!!
    }

    fun signup(mail: String,pass: String){
        email.value = mail
        password.value = pass
        loginState.value = true
    }


    fun addShoe(shoeItem: ShoeModel){
        shoeLit.value?.add(shoeItem)
    }


   fun checkValidationShoe(name:EditText,desc:EditText,size: EditText,company:EditText): ShoeModel? {
       if (isEmpty(name)|| isEmpty(size) || isEmpty(company) || isEmpty(desc)){
         return  null
       }
       return ShoeModel(name.text.toString(),size.text.toString().toDouble(),company.text.toString(),desc.text.toString())
   }


    private fun isEmpty(etText: EditText): Boolean {
        return etText.text.toString().trim { it <= ' ' }.isEmpty()

    }
}