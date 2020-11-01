package com.nhz.happy_delivery_app_by_nhz

import android.app.Application
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl

class DeliveryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        DeliveryModelImpl.initDatabase(applicationContext)
    }

}