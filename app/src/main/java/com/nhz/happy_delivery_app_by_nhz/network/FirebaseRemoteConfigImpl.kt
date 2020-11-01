package com.nhz.happy_delivery_app_by_nhz.network

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

object FirebaseRemoteConfigImpl {

    private val mRemoteConfig : FirebaseRemoteConfig = Firebase.remoteConfig

    init {
        val configSetting = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }
        mRemoteConfig.setConfigSettingsAsync(configSetting)
    }

    fun setDefaultValueToRemoteConfig(){
        val defaultValue : Map<String,Long> = hashMapOf(
            "viewtype" to  2
        )
        mRemoteConfig.setDefaultsAsync(defaultValue)
    }

    fun fetchRemoteConfig(){
        mRemoteConfig.fetch()
            .addOnCompleteListener {task ->
                if(task.isSuccessful){
                    mRemoteConfig.activate().addOnCompleteListener {
                        Log.d("TAG","Fetch Successful")
                    }
                }else {
                    Log.d("TAG","Fetch Failed")
                }
            }
    }

    fun getViewType() : Long{
        return mRemoteConfig.getLong("viewtype")
    }

}