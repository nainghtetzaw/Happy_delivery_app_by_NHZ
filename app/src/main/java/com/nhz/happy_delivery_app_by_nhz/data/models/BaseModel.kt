package com.nhz.happy_delivery_app_by_nhz.data.models

import android.content.Context
import com.nhz.happy_delivery_app_by_nhz.network.*
import com.nhz.happy_delivery_app_by_nhz.persistance.database.DeliveryDatabase

abstract class BaseModel {

    protected lateinit var deliveryDB : DeliveryDatabase
    val mFirebaseApi : FirebaseAPI = RealtimeDatabaseImpl
    val mFirebaseAuthApi : FirebaseAuthAPI = FirebaseAuthImpl
    val mFirebaseRemoteConfig : FirebaseRemoteConfigImpl = FirebaseRemoteConfigImpl

    fun initDatabase(context: Context) {
        deliveryDB = DeliveryDatabase.getDbInstance(context)
    }

}