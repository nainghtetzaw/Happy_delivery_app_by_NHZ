package com.nhz.happy_delivery_app_by_nhz.data.models

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.nhz.happy_delivery_app_by_nhz.data.vos.OrderedFoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO

interface DeliveryModel  {

    //Homefragment data
    fun getAllRestaurantTypeAndSaveToDatabase(onSuccess : (data : List<RestaurantTypeVO>) -> Unit, onFailure : (message : String) -> Unit)
    fun getAllRestaurantListAndSaveToDatabase(onSuccess: (data: List<RestaurantVO>) -> Unit, onFailure: (message: String) -> Unit)
    fun getRestaurantTypeData() : LiveData<List<RestaurantTypeVO>>
    fun getRestaurantListData() : LiveData<List<RestaurantVO>>

    //Order activity data
    fun getOrderFoodListDataById(onSuccess: (data: List<OrderedFoodListVO>) -> Unit,onFailure: (message: String) -> Unit,id: Int)
    fun getRestaurantById(id : Int) : LiveData<RestaurantVO>
    fun getUserDataByUserId(username : String, onSuccess: (data: UserVO) -> Unit, onFailure: (message: String) -> Unit)
    fun addOrderFoodList(id : Int,name : String,price : Int,counter : Int)
    fun addUserData(user : UserVO,onSuccess : (user : UserVO) -> Unit)
    fun uploadProfile(bitmap: Bitmap,onSuccess: (imgUrl : String) -> Unit)
    fun deleteOrderedFoodList(id : Int)

    //Remote Config
    fun setDefaultValueIntoRemoteConfig()
    fun fetchRemoteConfig()
    fun getViewType() : Long
}