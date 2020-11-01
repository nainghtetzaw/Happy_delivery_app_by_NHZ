package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModel
import com.nhz.happy_delivery_app_by_nhz.data.models.AuthModelImpl
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModel
import com.nhz.happy_delivery_app_by_nhz.data.models.DeliveryModelImpl
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.AbstractBasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.ProfilePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.ProfileView

class ProfilePresenterImpl :  AbstractBasePresenter<ProfileView>(), ProfilePresenter {

    private val mAuthModel : AuthModel = AuthModelImpl
    private val mModel : DeliveryModel = DeliveryModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestUserData(lifecycleOwner)
    }

    override fun onPhotoTaken(bitmap: Bitmap, onSuccess: (imgUrl: String) -> Unit) {
        mModel.uploadProfile(bitmap,onSuccess)
    }

    override fun onTapSaveBtn(user: UserVO) {
        mModel.addUserData(user,{})
    }

    private fun requestUserData(lifecycleOwner: LifecycleOwner){
        mModel.getUserDataByUsername(mAuthModel.getUserData().username,{
            mView?.showUserData(it)
        },{})
    }

}