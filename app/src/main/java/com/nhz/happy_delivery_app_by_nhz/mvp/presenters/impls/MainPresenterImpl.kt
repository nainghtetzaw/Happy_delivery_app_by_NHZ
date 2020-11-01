package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModel
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.MainPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.MainView

class MainPresenterImpl : AbstractBasePresenter<MainView>(),MainPresenter {

    private val mModel : DeliveryModel = DeliveryModelImpl

    override fun getViewTypeFromRemoteConfig(): Long {
        return mModel.getViewType()
    }
}