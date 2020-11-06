package com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.BasePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.ProfileView

interface ProfilePresenter : BasePresenter<ProfileView> {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onPhotoTaken(bitmap: Bitmap, onSuccess: (imgUrl: String) -> Unit)
    fun onTapSaveBtn(user: UserVO)
}