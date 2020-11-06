package com.nhz.happy_delivery_app_by_nhz.mvp.views

import com.nhz.happy_delivery_app_by_nhz.data.vos.OrderedFoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO

interface OrderFoodView : BaseView {

    fun showOrderedFoods(data : List<OrderedFoodListVO>,restaurant : RestaurantVO)
    fun showEmptyView()
    fun hideEmptyView()
    fun hideOrderView()

}