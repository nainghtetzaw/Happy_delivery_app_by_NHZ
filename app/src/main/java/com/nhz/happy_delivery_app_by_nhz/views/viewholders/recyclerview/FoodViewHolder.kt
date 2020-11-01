package com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nhz.happy_delivery_app_by_nhz.data.vos.FoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_food_list.view.*

class FoodViewHolder(itemview : View) : BaseViewHolder<FoodListVO>(itemview) {
    override fun onBindData(data: FoodListVO) {
        itemView.tvFoodName.text = data.name
        itemView.tvFoodPrice.text = "$${data.price}"
        itemView.tvFoodIngredient.text = data.ingredient

        if(data.popular){
            itemView.tvPopularFood.visibility = View.VISIBLE
        }else {
            itemView.tvPopularFood.visibility = View.INVISIBLE
        }
    }
}