package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModel
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.OrderFoodPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.OrderFoodView

class OrderFoodPresenterImpl : AbstractBasePresenter<OrderFoodView>(),OrderFoodPresenter {

    private val mModel : DeliveryModel = DeliveryModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner,id : Int) {
        requestData(lifecycleOwner,id)
    }

    override fun deleteOrderedFoodList(id: Int) {
        mModel.deleteOrderedFoodList(id)
    }

    private fun requestData(lifecycleOwner: LifecycleOwner,id: Int){
        mModel.getOrderFoodListDataById(onSuccess = {order ->
            mModel.getRestaurantById(id).observe(lifecycleOwner, Observer {restaurant ->
                mView?.showOrderedFoods(order,restaurant)
            })
        },{},id)
    }

}