package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import com.google.firebase.auth.FirebaseAuth
import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModel
import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModelImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.LoginPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.LoginView

class LoginPresenterImpl : AbstractBasePresenter<LoginView>(),LoginPresenter {

    private val mModel : AuthModel = AuthModelImpl

    override fun login(
        email: String,
        password: String,
        onSuccess: (pass: Boolean) -> Unit,
        onError: (message: String) -> Unit
    ) {
        mModel.login(email, password, onSuccess, onError)
    }
}