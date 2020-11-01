package com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_food_type.view.*

class FoodTypeViewHolder(itemview : View) : BaseViewHolder<RestaurantTypeVO>(itemview) {
    override fun onBindData(data: RestaurantTypeVO) {
        itemView.tvFoodType.text = data.name
        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.imgFoodType)
    }
}