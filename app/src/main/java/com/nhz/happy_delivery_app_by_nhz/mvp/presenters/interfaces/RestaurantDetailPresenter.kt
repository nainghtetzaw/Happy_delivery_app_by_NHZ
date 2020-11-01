package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces

import androidx.lifecycle.LifecycleOwner
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDetailDelegate
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.BasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.RestaurantDetailView

interface RestaurantDetailPresenter : BasePresenter<RestaurantDetailView>,RestaurantDetailDelegate {

    fun onUiReady(lifecycleOwner: LifecycleOwner,id : Int)

}