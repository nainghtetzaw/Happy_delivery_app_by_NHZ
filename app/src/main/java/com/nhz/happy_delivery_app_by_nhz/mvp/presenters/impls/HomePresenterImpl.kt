package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import android.content.Context
import android.view.Window
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModel
import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModelImpl
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModel
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDelegate
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.HomePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.HomeView

class HomePresenterImpl : AbstractBasePresenter<HomeView>(),HomePresenter {

    val mModel : DeliveryModel = DeliveryModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner,context: Context) {
        requestData(lifecycleOwner,context)
    }

    private fun requestData(lifecycleOwner: LifecycleOwner,context : Context) {
        mModel.getAllRestaurantListAndSaveToDatabase({}, onFailure = {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
        mModel.getAllRestaurantTypeAndSaveToDatabase({}, {})
        mModel.getRestaurantListData().observe(lifecycleOwner, Observer {
            mView?.setNewRestaurantList(it)
        })
        mModel.getRestaurantTypeData().observe(lifecycleOwner, Observer {
            mView?.setNewRestaurantType(it)
        })
    }

    override fun onTapRestaurant(id : Int) {
        mView?.navigateToRestaurantDetail(id)
    }
}