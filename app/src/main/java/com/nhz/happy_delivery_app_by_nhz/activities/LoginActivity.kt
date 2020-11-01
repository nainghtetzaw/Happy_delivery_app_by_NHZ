package com.nhz.happy_delivery_app_by_nhz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.LoginPresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.LoginPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),LoginView {

    private lateinit var mPresenter : LoginPresenter

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpPresenter()

        tvSignUp.setOnClickListener { startActivity(SignUpActivity.newIntent(this)) }
        imgLoginBack.setOnClickListener { finish() }
        btnLogin.setOnClickListener {
            mPresenter.login(etEmail.text.toString(),etPassword.text.toString(),onSuccess = {
                if(it){
                    startActivity(HomeActivity.newIntent(this))
                }
            },onError = {
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
}