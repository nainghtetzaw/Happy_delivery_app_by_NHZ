package com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview

import android.view.View
import com.bumptech.glide.Glide
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDelegate
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_new_restaurants.view.*
import kotlinx.android.synthetic.main.item_restaurant_list.view.*

class NewRestaurantViewHolder(itemview : View,val mDelegate : RestaurantDelegate) : BaseViewHolder<RestaurantVO>(itemview) {

    init {
        itemview.imgNewRestaurant.setOnClickListener {
            mData?.let {
                mDelegate.onTapRestaurant(it.id)
            }
        }
    }

    override fun onBindData(data: RestaurantVO) {
        mData = data

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.imgNewRestaurant)

        itemView.tvNewRestaurantName.text = data.name
        itemView.tvNewRestaurantRating.text = data.rating.toString()
        itemView.tvNewRestaurantRatingAmount.text = "(${data.rating_amount})"
        itemView.tvNewRestaurantType.text = "${data.food_type} - ${data.restaurant_type} - $$"
    }
}