package com.nhz.happy_delivery_app_by_nhz.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Restaurant_type")
data class RestaurantTypeVO (
    @PrimaryKey(autoGenerate = false)
    val id : Int = 0,
    val image : String = "",
    val name : String = ""
)