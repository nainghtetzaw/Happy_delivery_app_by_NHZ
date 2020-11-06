package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.MainPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.MainView

class MainPresenterImpl : AbstractBasePresenter<MainView>(), MainPresenter {

    override fun getViewTypeFromRemoteConfig(): Long {
        return mModel.getViewType()
    }
}