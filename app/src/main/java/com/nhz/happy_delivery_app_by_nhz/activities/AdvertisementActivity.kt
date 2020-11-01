package com.nhz.happy_delivery_app_by_nhz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.AdvertisemantPresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.AdvertisemantPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.AdvertisementView
import kotlinx.android.synthetic.main.activity_advertisement.*

class AdvertisementActivity : AppCompatActivity(),AdvertisementView {

    private lateinit var mPresenter : AdvertisemantPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertisement)
        setUpPresenter()

        mPresenter.onUiReady()

        btnGetStarted.setOnClickListener { startActivity(IntroSliderActivity.newIntent(this)) }

    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(AdvertisemantPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

}