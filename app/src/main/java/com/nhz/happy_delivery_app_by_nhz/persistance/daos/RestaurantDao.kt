package com.nhz.happy_delivery_app_by_nhz.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO

@Dao
interface RestaurantDao  {

    @Query("Select * From Restaurant")
    fun getAllDataFromRestaurantDatabase() : LiveData<List<RestaurantVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataIntoRestaurantDatabase(data : List<RestaurantVO>)

    @Query("Select * From Restaurant Where id = :id")
    fun getRestaurantDataById(id : Int) : LiveData<RestaurantVO>
}