package com.nhz.happy_delivery_app_by_nhz.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO

@Dao
interface RestaurantTypeDao {

    @Query("Select * From Restaurant_type")
    fun getAllDataFromRestaurantTypeDatabase() : LiveData<List<RestaurantTypeVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataIntoRestaurantTypeDatabase(data : List<RestaurantTypeVO>)

}