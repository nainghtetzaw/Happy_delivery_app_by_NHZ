package com.nhz.happy_delivery_app_by_nhz.activities

import android.content.Context
import android.content.Intent
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.ProfilePresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.ProfilePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.ProfileView
import kotlinx.android.synthetic.main.activity_profile.*
import java.io.IOException

class ProfileActivity : AppCompatActivity(),ProfileView {

    private var mUserData : UserVO = UserVO()
    private lateinit var mPresenter : ProfilePresenter
    private val REQUEST_CODE = 1111
    private var imageUrl : String = ""

    companion object{
        const val USERNAME = "USERNAME"

        fun newIntent(context: Context) : Intent {
            return  Intent(context,ProfileActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setUpPresenter()
        tvCancel.setOnClickListener { finish() }

        mPresenter.onUiReady(this)

        imgOpenGallery.setOnClickListener {
            openGallary()
        }

        tvSave.setOnClickListener {
            mPresenter.onTapSaveBtn(mUserData)
            startActivity(HomeActivity.newIntent(this))
        }

    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE || resultCode == REQUEST_CODE){
            if(data == null || data.data == null){
                return
            }
            val path = data.data
            try{
                path?.let {
                    if(Build.VERSION.SDK_INT == 29){
                        val source : ImageDecoder.Source = ImageDecoder.createSource(this.contentResolver,path)
                        val bitmap = ImageDecoder.decodeBitmap(source)
                        mPresenter.onPhotoTaken(bitmap,onSuccess = {
                            Glide.with(this)
                                .load(it)
                                .into(imgProfile)
                            imageUrl = it
                            mUserData.photoUrl = it
                        })
                    }else {
                        val bitmap = MediaStore.Images.Media.getBitmap(
                            this.contentResolver,path
                        )
                        mPresenter.onPhotoTaken(bitmap,onSuccess = {
                            Glide.with(this)
                                .load(it)
                                .into(imgProfile)
                            imageUrl = it
                            mUserData.photoUrl = it
                        })
                    }
                }
            }catch (e : IOException){
                e.printStackTrace()
            }
        }
    }

    override fun showUserData(user: UserVO) {
        mUserData = user
        tvUsername.text = user.username
        tvEmail.text = user.email

        if(user.photoUrl.isNotEmpty()){
            Glide.with(this)
                .load(user.photoUrl)
                .into(imgProfile)
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun openGallary(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, REQUEST_CODE)
    }
}