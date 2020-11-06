package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.AdvertisemantPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.AdvertisementView

class AdvertisemantPresenterImpl : AbstractBasePresenter<AdvertisementView>(),
    AdvertisemantPresenter {

    override fun onUiReady() {
        mModel.setDefaultValueIntoRemoteConfig()
        mModel.fetchRemoteConfig()
    }
}