package com.nhz.happy_delivery_app_by_nhz.network

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.nhz.happy_delivery_app_by_nhz.data.vos.OrderedFoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO
import java.io.ByteArrayOutputStream
import java.net.URL
import java.util.*

object RealtimeDatabaseImpl : FirebaseAPI {

    private val mDatabase : DatabaseReference = Firebase.database.reference
    private val storage = Firebase.storage
    private val storageReferance = storage.reference

    override fun getAllRestaurantType(
        onSuccess: (data: List<RestaurantTypeVO>) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        mDatabase.child("restaurant_type").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val restaurantTypeList = arrayListOf<RestaurantTypeVO>()
                snapshot.children.forEach { dataSnapshot ->
                    dataSnapshot.getValue(RestaurantTypeVO::class.java)?.let {
                        restaurantTypeList.add(it)
                    }
                }
                onSuccess(restaurantTypeList)
            }
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }
        })
    }

    override fun getAllRestaurantData(
        onSuccess: (data: List<RestaurantVO>) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        mDatabase.child("restaurants").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val restaurantList = arrayListOf<RestaurantVO>()
                snapshot.children.forEach { dataSnapshot ->
                    dataSnapshot.getValue(RestaurantVO::class.java)?.let {
                        restaurantList.add(it)
                    }
                }
                onSuccess(restaurantList)
            }

            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

        })
    }

    override fun getAllOrderedFoodDataById(
        onSuccess: (data: List<OrderedFoodListVO>) -> Unit,
        onFailure: (message: String) -> Unit,
        id: Int
    ) {
        mDatabase.child("ordered_food_list").child(id.toString()).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val orderFoodList = arrayListOf<OrderedFoodListVO>()
                snapshot.children.forEach { dataSnapshot ->
                    dataSnapshot.getValue(OrderedFoodListVO::class.java)?.let {
                        orderFoodList.add(it)
                    }
                }
                onSuccess(orderFoodList)
            }

            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

        })
    }

    override fun getAllUserDataByUsername(
        username: String,
        onSuccess: (data: UserVO) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        mDatabase.child("users").child(username).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var user = UserVO()
                snapshot.children.forEach { dataSnapshot ->
                    dataSnapshot.getValue(UserVO::class.java)?.let{
                        user = it
                    }
                }
                onSuccess(user)
            }

            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

        })
    }

    override fun addOrderedFoodIntoNetwork(id : Int,name : String,price : Int,quantity : Int) {
        mDatabase.child("ordered_food_list").child(id.toString()).child(name).setValue(OrderedFoodListVO(name,price,quantity))
    }

    override fun addUserIntoDatabase(user: UserVO,onSuccess: (user : UserVO) -> Unit) {
        mDatabase.child("users").child(user.id).child(user.id).setValue(user)
        onSuccess(user)
    }

    override fun uploadProfile(bitmap: Bitmap, onSuccess: (imgUrl: String) -> Unit) {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos)
        val data = baos.toByteArray()

        val imageRef = storageReferance.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putBytes(data)
        uploadTask.addOnFailureListener{

        }.addOnSuccessListener {

        }
        val urlTask = uploadTask.continueWithTask{
            return@continueWithTask imageRef.downloadUrl
        }.addOnCompleteListener{task ->
            val url = task.result
            val imageUrl  = task.result?.toString()
            imageUrl?.let {urlString ->
                    Log.e("URL",urlString)
                    onSuccess(urlString)
            }
        }
    }

    override fun deleteOrderedFoodList(id : Int) {
        mDatabase.child("ordered_food_list").child(id.toString()).removeValue()
    }


}