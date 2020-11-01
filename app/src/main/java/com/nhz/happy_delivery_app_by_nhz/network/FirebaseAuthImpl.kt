package com.nhz.happy_delivery_app_by_nhz.network

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.UserProfileChangeRequest
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO

object FirebaseAuthImpl : FirebaseAuthAPI {

    private val mFirebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun login(
        email: String,
        password: String,
        onSuccess: (pass: Boolean) -> Unit,
        onError: (message: String) -> Unit
    ) {
        mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful && it.isComplete){
                onSuccess(true)
            }else{
                onError(it.exception?.message ?: "Please check your internet connection!")
            }
        }
    }

    override fun signInNewAcc(
        username: String,
        email: String,
        password: String,
        onSuccess: (pass: Boolean,user : UserVO) -> Unit,
        onError: (message: String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful && it.isComplete){
                mFirebaseAuth.currentUser?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(username).build()
                )
                onSuccess(true,UserVO(username,"",email,username))
            }else{
                onError(it.exception?.message ?: "")
            }
        }
    }


    override fun getUserData(): UserVO {
        return UserVO(mFirebaseAuth.currentUser?.displayName ?: "",
        mFirebaseAuth.currentUser?.photoUrl.toString(),
            mFirebaseAuth.currentUser?.email ?: "",
        mFirebaseAuth.currentUser?.displayName ?: "")
    }


}