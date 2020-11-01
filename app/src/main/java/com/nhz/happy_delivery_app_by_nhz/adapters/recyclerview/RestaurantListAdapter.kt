package com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.adapters.BaseAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDelegate
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview.RestaurantListViewHolder

class RestaurantListAdapter(delegate : RestaurantDelegate) : BaseAdapter<RestaurantListViewHolder,RestaurantVO>() {

    private val mDelegate : RestaurantDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_list,parent,false)
        return RestaurantListViewHolder(view,mDelegate)
    }
}