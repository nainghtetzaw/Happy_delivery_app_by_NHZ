package com.nhz.happy_delivery_app_by_nhz.views.viewholders.viewpager

import android.view.View
import com.bumptech.glide.Glide
import com.nhz.happy_delivery_app_by_nhz.data.vos.IntroSliderVO
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.slider_layout.view.*

class IntroSliderViewHolder(itemview : View) : BaseViewHolder<IntroSliderVO>(itemview) {
    override fun onBindData(data: IntroSliderVO) {
        itemView.imgIntroSlider.setImageResource(data.image)
        itemView.tvIntroHeading.text = data.heading
        itemView.tvIntroDescription.text = data.description
    }
}