package com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview

import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDelegate
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_restaurant_list.view.*

class PopularChoiceViewHolder(itemview : View,val mDelegate : RestaurantDelegate) : BaseViewHolder<RestaurantVO>(itemview) {

    init {
        itemview.imgRestaurant.setOnClickListener {
            mData?.let {
                mDelegate.onTapRestaurant(it.id)
            }
        }
    }

    override fun onBindData(data: RestaurantVO) {

        mData = data
        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.imgRestaurant)

        itemView.tvRestaurantName.text = data.name
        itemView.tvRestaurantRating.text = data.rating.toString()
        itemView.tvRestaurantInfo.text = "(${data.rating_amount}) ${data.food_type} - ${data.restaurant_type} - $$"
    }
}