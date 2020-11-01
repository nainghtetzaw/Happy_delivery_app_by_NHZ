package com.nhz.happy_delivery_app_by_nhz.mvp.presenters

import androidx.lifecycle.ViewModel
import com.nhz.happy_delivery_app_by_nhz.mvp.views.BaseView

abstract class AbstractBasePresenter<V : BaseView> : BasePresenter<V>,ViewModel() {

    var mView : V ?= null

    override fun initPresenter(view: V) {
        mView = view
    }

}