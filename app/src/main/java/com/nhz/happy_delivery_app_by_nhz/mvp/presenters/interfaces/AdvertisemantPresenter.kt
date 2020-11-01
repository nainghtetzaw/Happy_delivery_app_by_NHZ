package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces

import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.BasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.AdvertisementView

interface AdvertisemantPresenter : BasePresenter<AdvertisementView> {

    fun onUiReady()
}