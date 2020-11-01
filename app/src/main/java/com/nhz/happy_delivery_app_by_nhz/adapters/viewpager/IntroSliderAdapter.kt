package com.nhz.happy_delivery_app_by_nhz.adapters.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.adapters.BaseAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.IntroSliderVO
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.viewpager.IntroSliderViewHolder

class IntroSliderAdapter : BaseAdapter<IntroSliderViewHolder,IntroSliderVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_layout,parent,false)
        return IntroSliderViewHolder(view)
    }
}