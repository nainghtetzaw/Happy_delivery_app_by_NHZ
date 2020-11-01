package com.nhz.happy_delivery_app_by_nhz.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nhz.happy_delivery_app_by_nhz.data.vos.FoodListVO

class FoodListTypeConverter {

    @TypeConverter
    fun toString(data : ArrayList<FoodListVO>) : String{
        return Gson().toJson(data)
    }

    @TypeConverter
    fun toList(data: String) : ArrayList<FoodListVO>{
        val dataType = object: TypeToken<ArrayList<FoodListVO>>() {}.type
        return Gson().fromJson(data,dataType)
    }
}