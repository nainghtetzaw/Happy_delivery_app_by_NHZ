package com.nhz.happy_delivery_app_by_nhz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.SignUpPresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.SignUpPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.SignUpView
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(),SignUpView {

    private lateinit var mPresenter : SignUpPresenter

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,SignUpActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setUpPresenter()

        tvLogin.setOnClickListener { startActivity(LoginActivity.newIntent(this)) }
        imgSignUpBack.setOnClickListener { finish() }
        btnSignUp.setOnClickListener {
            mPresenter.signIn(etUsername.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString(),
                onSuccess = { pass,username ->
                    if (pass){
                        startActivity(HomeActivity.newIntent(this))
                    }
                },onError = {
                    Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(SignUpPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
}