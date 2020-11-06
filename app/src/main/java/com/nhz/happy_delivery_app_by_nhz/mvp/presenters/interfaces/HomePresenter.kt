package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDelegate
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.BasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.HomeView

interface HomePresenter : BasePresenter<HomeView>, RestaurantDelegate {

    fun onUiReady(lifecycleOwner: LifecycleOwner, context: Context)
}