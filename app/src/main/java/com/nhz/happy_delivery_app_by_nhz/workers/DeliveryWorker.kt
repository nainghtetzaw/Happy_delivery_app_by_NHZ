package com.nhz.happy_delivery_app_by_nhz.workers

import android.content.Context
import androidx.work.WorkerParameters

class DeliveryWorker(context: Context,workerParams : WorkerParameters) : BaseDeliveryWorker(context,workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        mModel.getAllRestaurantTypeAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onFailure = {
                result = Result.failure()
            }
        )
        mModel.getAllRestaurantListAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onFailure = {
                result = Result.failure()
            }
        )
        mModel.getRestaurantListData()
        mModel.getRestaurantTypeData()
        return result
    }
}