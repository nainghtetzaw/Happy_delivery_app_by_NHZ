package com.nhz.happy_delivery_app_by_nhz.mvp.views

import com.nhz.happy_delivery_app_by_nhz.data.vos.FoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO

interface RestaurantDetailView : BaseView {

    fun setNewData(data : RestaurantVO)
    fun addOrderFood() : RestaurantVO
}