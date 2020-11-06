package com.nhz.happy_delivery_app_by_nhz

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl
import com.nhz.happy_delivery_app_by_nhz.workers.DeliveryWorker

class DeliveryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        DeliveryModelImpl.initDatabase(applicationContext)
        getRestaurantOneTime()
    }

    private fun getRestaurantOneTime(){
        val getEventWorkOneTime = OneTimeWorkRequest
            .Builder(DeliveryWorker::class.java)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventWorkOneTime)
    }

}