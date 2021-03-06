package com.nhz.happy_delivery_app_by_nhz.data.models

import android.net.Uri
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO

interface AuthModel {

    fun login(email : String,password : String,onSuccess : (pass : Boolean) -> Unit,onError : (message : String) -> Unit)
    fun signInNewAcc(username : String, email : String, password : String,onSuccess : (pass: Boolean,user : UserVO) -> Unit, onError: (message: String) -> Unit)
    fun getUserData() : UserVO
}