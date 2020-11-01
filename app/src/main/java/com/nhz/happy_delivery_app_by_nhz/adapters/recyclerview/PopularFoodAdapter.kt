package com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.adapters.BaseAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.FoodListVO
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDetailDelegate
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview.PopularFoodViewHolder

class PopularFoodAdapter(delegate : RestaurantDetailDelegate) : BaseAdapter<PopularFoodViewHolder,FoodListVO>() {

    private val mDelegate : RestaurantDetailDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_food_list,parent,false)
        return PopularFoodViewHolder(view,mDelegate)
    }
}