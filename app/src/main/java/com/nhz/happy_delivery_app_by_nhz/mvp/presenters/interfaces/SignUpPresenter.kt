package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces

import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.BasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.SignUpView

interface SignUpPresenter : BasePresenter<SignUpView> {

    fun signIn(username : String, email : String, password : String, onSuccess: (pass: Boolean,username : String) -> Unit, onError: (message: String) -> Unit)

}