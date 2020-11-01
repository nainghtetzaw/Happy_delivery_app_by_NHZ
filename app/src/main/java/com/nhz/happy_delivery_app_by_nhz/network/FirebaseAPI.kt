package com.nhz.happy_delivery_app_by_nhz.network

import android.graphics.Bitmap
import android.net.Uri
import com.nhz.happy_delivery_app_by_nhz.data.vos.OrderedFoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO
import java.net.URL

interface FirebaseAPI {
    fun getAllRestaurantType(onSuccess : (data : List<RestaurantTypeVO>) -> Unit, onFailure : (message : String) -> Unit)
    fun getAllRestaurantData(onSuccess: (data: List<RestaurantVO>) -> Unit, onFailure: (message: String) -> Unit)
    fun getAllOrderedFoodDataById(onSuccess: (data: List<OrderedFoodListVO>) -> Unit,onFailure: (message: String) -> Unit,id: Int)
    fun getAllUserDataByUsername(username : String,onSuccess: (data: UserVO) -> Unit,onFailure: (message: String) -> Unit)
    fun addOrderedFoodIntoNetwork(id : Int,name : String,price : Int,quantity: Int)
    fun addUserIntoDatabase(user : UserVO,onSuccess: (user : UserVO) -> Unit)
    fun uploadProfile(bitmap : Bitmap,onSuccess: (imgUrl : String) -> Unit)
    fun deleteOrderedFoodList(id : Int)
}