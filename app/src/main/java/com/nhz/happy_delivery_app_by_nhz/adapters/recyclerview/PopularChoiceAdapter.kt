package com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview

import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.adapters.BaseAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDelegate
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview.PopularChoiceViewHolder

class PopularChoiceAdapter(delegate: RestaurantDelegate) : BaseAdapter<PopularChoiceViewHolder,RestaurantVO>() {

    private val mDelegate : RestaurantDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularChoiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_list,parent,false)
        return PopularChoiceViewHolder(view,mDelegate)
    }
}