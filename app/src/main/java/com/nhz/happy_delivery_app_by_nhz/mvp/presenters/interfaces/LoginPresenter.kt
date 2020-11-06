package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces

import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.BasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.LoginView

interface LoginPresenter : BasePresenter<LoginView> {
    fun login(
        email: String,
        password: String,
        onSuccess: (pass: Boolean) -> Unit,
        onError: (message: String) -> Unit
    )
}