package com.nhz.happy_delivery_app_by_nhz.mvp.presenters

import androidx.lifecycle.ViewModel
import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModel
import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModelImpl
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModel
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.views.BaseView

abstract class AbstractBasePresenter<V : BaseView> : BasePresenter<V>, ViewModel() {

    val mModel: DeliveryModel = DeliveryModelImpl
    val mAuthModel: AuthModel = AuthModelImpl

    var mView: V? = null

    override fun initPresenter(view: V) {
        mView = view
    }

}