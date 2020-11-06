package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.SignUpPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.SignUpView

class SignUpPresenterImpl : AbstractBasePresenter<SignUpView>(), SignUpPresenter {
    private var mId: String = ""

    override fun signIn(
        username: String,
        email: String,
        password: String,
        onSuccess: (pass: Boolean, username: String) -> Unit,
        onError: (message: String) -> Unit
    ) {
        mAuthModel.signInNewAcc(username, email, password, { pass, user ->
            mModel.addUserData(user) {
                mId = it.id
            }
            onSuccess(pass, mId)

        }, onError)
    }
}