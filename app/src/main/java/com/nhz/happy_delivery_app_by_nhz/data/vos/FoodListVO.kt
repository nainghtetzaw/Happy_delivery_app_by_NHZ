package com.nhz.happy_delivery_app_by_nhz.data.vos

import androidx.room.Entity

data class FoodListVO (
    val image : String = "",
    val name : String = "",
    val price : Int = 0,
    val popular : Boolean = false,
    val ingredient : String = ""
)