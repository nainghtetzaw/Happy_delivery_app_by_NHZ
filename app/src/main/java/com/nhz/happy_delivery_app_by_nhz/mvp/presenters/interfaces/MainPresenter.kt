package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces

import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.BasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView> {

    fun getViewTypeFromRemoteConfig() : Long

}