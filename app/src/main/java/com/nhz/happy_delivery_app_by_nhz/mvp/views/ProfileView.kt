package com.nhz.happy_delivery_app_by_nhz.mvp.views

import com.nhz.happy_delivery_app_by_nhz.data.vos.UserVO

interface ProfileView : BaseView {

    fun showUserData(user : UserVO)

}