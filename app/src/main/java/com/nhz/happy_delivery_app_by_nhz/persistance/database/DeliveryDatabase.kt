package com.nhz.happy_delivery_app_by_nhz.persistance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nhz.happy_delivery_app_by_nhz.data.vos.FoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.OrderedFoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.persistance.daos.RestaurantDao
import com.nhz.happy_delivery_app_by_nhz.persistance.daos.RestaurantTypeDao

@Database(entities = [RestaurantVO::class,RestaurantTypeVO::class],version = 13,exportSchema = false)
abstract class DeliveryDatabase : RoomDatabase() {

    companion object{
        private val DB_NAME = "Delivery_Database"
        private var dbInstance : DeliveryDatabase ?= null

        fun getDbInstance(context: Context) : DeliveryDatabase{
            when(dbInstance){
                null -> {
                    dbInstance = Room.databaseBuilder(context,DeliveryDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstance!!
        }

    }

    abstract fun restaurantDao() : RestaurantDao
    abstract fun restaurantTypeDao() : RestaurantTypeDao

}