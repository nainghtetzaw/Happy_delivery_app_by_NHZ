package com.nhz.happy_delivery_app_by_nhz.mvp.views

import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO

interface HomeView : BaseView {

    fun setNewRestaurantType(data : List<RestaurantTypeVO>)
    fun setNewRestaurantList(data : List<RestaurantVO>)
    fun navigateToRestaurantDetail(id : Int)

}