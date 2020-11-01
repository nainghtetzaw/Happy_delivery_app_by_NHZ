package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModel
import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModelImpl
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModel
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.SignUpPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.SignUpView

class SignUpPresenterImpl : AbstractBasePresenter<SignUpView>(),SignUpPresenter {

    private val mAuthModel : AuthModel = AuthModelImpl
    private val mModel : DeliveryModel = DeliveryModelImpl
    private var mUsername : String = ""

    override fun signIn(
        username: String,
        email: String,
        password: String,
        onSuccess: (pass: Boolean,username : String) -> Unit,
        onError: (message: String) -> Unit
    ) {
        mAuthModel.signInNewAcc(username, email, password,{pass, user ->
            mModel.addUserData(user,{
                mUsername = it.username
            })
            onSuccess(pass,mUsername)

        }, onError)
    }
}