package com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nhz.happy_delivery_app_by_nhz.data.vos.OrderedFoodListVO
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.item_order.view.*

class OrderViewHolder(itemview : View) : BaseViewHolder<OrderedFoodListVO>(itemview) {
    override fun onBindData(data: OrderedFoodListVO) {
        itemView.tvOrderedItemName.text = "${data.name} + ${data.quantity}"
        itemView.tvOrderedItemPrice.text = "$${data.price * data.quantity}"
    }
}