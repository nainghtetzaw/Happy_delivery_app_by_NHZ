package com.nhz.happy_delivery_app_by_nhz.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemview : View) : RecyclerView.ViewHolder(itemview) {

    var mData : T ?= null

    abstract fun onBindData(data : T)

}