package com.nhz.happy_delivery_app_by_nhz.activities

import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.fragments.HomeFragment
import com.nhz.happy_delivery_app_by_nhz.fragments.HomeFragment2
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.HomePresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.MainPresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.HomePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.MainPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.HomeView
import com.nhz.happy_delivery_app_by_nhz.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_home.*
import java.lang.ClassCastException

class HomeActivity : AppCompatActivity(),MainView {

    private val fragment1 : HomeFragment = HomeFragment()
    private val fragment2 : HomeFragment2 = HomeFragment2()
    private lateinit var mPresenter : MainPresenter

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,HomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpPresenter()
        identifyFragments()
    }

    private fun identifyFragments(){
        Toast.makeText(this,mPresenter.getViewTypeFromRemoteConfig().toString(),Toast.LENGTH_SHORT).show()

        if (mPresenter.getViewTypeFromRemoteConfig().toInt() == 1){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer,fragment1)
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer,fragment2)
                .hide(fragment2)
                .commit()

            btnNaviEventListener(fragment1)

        }else {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer,fragment2)
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer,fragment1)
                .hide(fragment1)
                .commit()

            btnNaviEventListener(fragment2)

        }

    }
    private fun btnNaviEventListener(fragmentType : Fragment){
        var activeFragment: Fragment = fragmentType

        btnNavi.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.menuHome -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(fragmentType).commit()
                    activeFragment = fragmentType
                    true
                }
                else -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(fragmentType).commit()
                    activeFragment = fragmentType
                    true
                }

            }
        }

    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

}