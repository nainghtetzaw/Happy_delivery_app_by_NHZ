package com.nhz.happy_delivery_app_by_nhz.data.models

import android.net.Uri
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO

object AuthModelImpl : BaseModel(),AuthModel {
    override fun login(
        email: String,
        password: String,
        onSuccess: (pass: Boolean) -> Unit,
        onError: (message: String) -> Unit
    ) {
        mFirebaseAuthApi.login(email, password, onSuccess, onError)
    }

    override fun signInNewAcc(
        username: String,
        email: String,
        password: String,
        onSuccess: (pass: Boolean,user : UserVO) -> Unit,
        onError: (message: String) -> Unit
    ) {
        mFirebaseAuthApi.signInNewAcc(username, email, password, onSuccess, onError)
    }

    override fun getUserData(): UserVO {
        return mFirebaseAuthApi.getUserData()
    }


}