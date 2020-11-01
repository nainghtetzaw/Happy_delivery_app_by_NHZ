package com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.adapters.BaseAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview.FoodTypeViewHolder

class FoodTypeAdapter : BaseAdapter<FoodTypeViewHolder,RestaurantTypeVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodTypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_type,parent,false)
        return FoodTypeViewHolder(view)
    }
}