package com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.data.vos.FoodListVO
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview.FoodViewHolder

class FoodAdapter : com.nhz.happy_delivery_app_by_nhz.adapters.BaseAdapter<FoodViewHolder,FoodListVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_list,parent,false)
        return FoodViewHolder(view)
    }

}