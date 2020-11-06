package com.nhz.happy_delivery_app_by_nhz.data.models

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.nhz.happy_delivery_app_by_nhz.data.vos.OrderedFoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO

object DeliveryModelImpl : DeliveryModel, BaseModel() {

    override fun getAllRestaurantTypeAndSaveToDatabase(
        onSuccess: (data: List<RestaurantTypeVO>) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        mFirebaseApi.getAllRestaurantType(onSuccess = {
            onSuccess(it)
            deliveryDB.restaurantTypeDao().insertDataIntoRestaurantTypeDatabase(it)
        },onFailure)
    }

    override fun getAllRestaurantListAndSaveToDatabase(
        onSuccess: (data: List<RestaurantVO>) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        mFirebaseApi.getAllRestaurantData(onSuccess = {
            onSuccess(it)
            deliveryDB.restaurantDao().insertDataIntoRestaurantDatabase(it)
        },onFailure)
    }

    override fun getRestaurantTypeData(): LiveData<List<RestaurantTypeVO>> {
        return deliveryDB.restaurantTypeDao().getAllDataFromRestaurantTypeDatabase()
    }

    override fun getRestaurantListData(): LiveData<List<RestaurantVO>> {
        return deliveryDB.restaurantDao().getAllDataFromRestaurantDatabase()
    }

    override fun getOrderFoodListDataById(
        onSuccess: (data: List<OrderedFoodListVO>) -> Unit,
        onFailure: (message: String) -> Unit,
        id: Int
    ) {
        mFirebaseApi.getAllOrderedFoodDataById(onSuccess,onFailure,id)
    }

    override fun getRestaurantById(id: Int): LiveData<RestaurantVO> {
        return deliveryDB.restaurantDao().getRestaurantDataById(id)
    }

    override fun getUserDataByUserId(
        username: String,
        onSuccess: (data: UserVO) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        mFirebaseApi.getAllUserDataByUserId(username,onSuccess,onFailure)
    }

    override fun addOrderFoodList(id: Int, name: String, price: Int,counter : Int) {
        mFirebaseApi.addOrderedFoodIntoNetwork(id,name,price,counter)
    }

    override fun addUserData(user: UserVO,onSuccess: (user : UserVO) -> Unit) {
        mFirebaseApi.addUserIntoDatabase(user,onSuccess)
    }

    override fun uploadProfile(bitmap: Bitmap, onSuccess: (imgUrl: String) -> Unit) {
        mFirebaseApi.uploadProfile(bitmap,onSuccess)
    }

    override fun deleteOrderedFoodList(id: Int) {
        mFirebaseApi.deleteOrderedFoodList(id)
    }

    override fun setDefaultValueIntoRemoteConfig() {
        mFirebaseRemoteConfig.setDefaultValueToRemoteConfig()
    }

    override fun fetchRemoteConfig() {
        mFirebaseRemoteConfig.fetchRemoteConfig()
    }

    override fun getViewType(): Long {
        return mFirebaseRemoteConfig.getViewType()
    }


}