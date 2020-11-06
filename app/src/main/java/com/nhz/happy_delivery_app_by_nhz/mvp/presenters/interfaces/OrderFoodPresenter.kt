package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces

import androidx.lifecycle.LifecycleOwner
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.BasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.OrderFoodView

interface OrderFoodPresenter : BasePresenter<OrderFoodView> {

    fun onUiReady(lifecycleOwner: LifecycleOwner, id: Int)
    fun deleteOrderedFoodList(id: Int)
}