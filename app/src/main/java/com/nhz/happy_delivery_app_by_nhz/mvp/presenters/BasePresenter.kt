package com.nhz.happy_delivery_app_by_nhz.mvp.presenters

import com.nhz.happy_delivery_app_by_nhz.mvp.views.BaseView

interface BasePresenter<T : BaseView> {

    fun initPresenter(view : T)

}