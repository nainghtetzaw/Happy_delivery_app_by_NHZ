package com.nhz.happy_delivery_app_by_nhz.adapters

import androidx.recyclerview.widget.RecyclerView
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.BaseViewHolder

abstract class BaseAdapter<W : BaseViewHolder<T>,T> : RecyclerView.Adapter<W>(){

    var mData : MutableList<T> = mutableListOf()

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: W, position: Int) {
        holder.onBindData(mData[position])
    }

    fun setNewData(data : MutableList<T>){
        mData = data
        notifyDataSetChanged()
    }

}