package com.nhz.happy_delivery_app_by_nhz.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModel
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl

abstract class BaseDeliveryWorker(context: Context,workerParams : WorkerParameters) : Worker(context,workerParams) {

    val mModel : DeliveryModel = DeliveryModelImpl
}