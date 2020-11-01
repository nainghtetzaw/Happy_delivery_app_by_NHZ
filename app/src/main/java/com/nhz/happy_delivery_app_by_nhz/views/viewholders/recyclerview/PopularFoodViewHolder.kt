package com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nhz.happy_delivery_app_by_nhz.data.vos.FoodListVO
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDetailDelegate
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_popular_food_list.view.*

class PopularFoodViewHolder(itemview : View,val mDelegate : RestaurantDetailDelegate) : BaseViewHolder<FoodListVO>(itemview) {

    private var counter : Int = 0

    init {
        itemview.imgAddFood.setOnClickListener {
            counter ++
            mData?.let {
                mDelegate.onTapAddFood(it.name,it.price,counter)
            }
        }
    }

    override fun onBindData(data: FoodListVO) {

        mData  = data

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.imgPopularFood)

        itemView.tvPopularFoodName.text = data.name
        itemView.tvPopularFoodPrice.text = "$${data.price}"
    }
}