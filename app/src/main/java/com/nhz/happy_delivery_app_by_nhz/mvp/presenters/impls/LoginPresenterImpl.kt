package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.LoginPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.LoginView

class LoginPresenterImpl : AbstractBasePresenter<LoginView>(), LoginPresenter {
    override fun login(
        email: String,
        password: String,
        onSuccess: (pass: Boolean) -> Unit,
        onError: (message: String) -> Unit
    ) {
        mAuthModel.login(email, password, onSuccess, onError)
    }
}