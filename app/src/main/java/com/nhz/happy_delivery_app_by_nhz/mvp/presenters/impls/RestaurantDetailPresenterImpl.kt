package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModel
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.RestaurantDetailPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.RestaurantDetailView

class RestaurantDetailPresenterImpl : AbstractBasePresenter<RestaurantDetailView>(),RestaurantDetailPresenter {

    private val mModel : DeliveryModel = DeliveryModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner,id : Int) {
        requestData(lifecycleOwner,id)
    }

    override fun onTapAddFood(name: String, price: Int,counter : Int) {
        mView?.addOrderFood()?.let {
            mModel.addOrderFoodList(it.id,name,price,counter)
        }
    }

    private fun requestData(lifecycleOwner: LifecycleOwner,id : Int){
        mModel.getRestaurantById(id).observe(lifecycleOwner, Observer {
            mView?.setNewData(it)
        })
    }

}