package com.nhz.happy_delivery_app_by_nhz.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nhz.happy_delivery_app_by_nhz.persistance.typeconverters.FoodListTypeConverter

@Entity(tableName = "Restaurant")
@TypeConverters(FoodListTypeConverter::class)
data class RestaurantVO (
    @PrimaryKey(autoGenerate = false)
    val id : Int = 0,
    val image : String = "",
    val name : String = "",
    val rating : Double = 0.0,
    val rating_amount : Int = 0,
    val food_type : String = "",
    val restaurant_type : String = "",
    val popular_choice : Boolean = false,
    val location : String = "",
    val food_list : ArrayList<FoodListVO> = arrayListOf()
)