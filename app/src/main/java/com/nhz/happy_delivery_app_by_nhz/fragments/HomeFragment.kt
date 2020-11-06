package com.nhz.happy_delivery_app_by_nhz.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.activities.LoginActivity
import com.nhz.happy_delivery_app_by_nhz.activities.OrderActivity
import com.nhz.happy_delivery_app_by_nhz.activities.ProfileActivity
import com.nhz.happy_delivery_app_by_nhz.activities.RestaurantDetailActivity
import com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview.FoodTypeAdapter
import com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview.RestaurantListAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.HomePresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.HomePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),HomeView {
    private lateinit var mFoodTypeAdapter : FoodTypeAdapter
    private lateinit var mRestaurantListAdapter : RestaurantListAdapter
    private lateinit var mLinearLayoutManager : LinearLayoutManager
    private lateinit var mPresenter : HomePresenter
    private var mRestaurantNameList : ArrayList<String> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpRecyclerView()
        activity?.let {
            if (isAdded){
                mPresenter.onUiReady(this,it.applicationContext)
                setUpAutoCompleteTextView(it)
                setUpListener()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun setUpRecyclerView(){
        mFoodTypeAdapter = FoodTypeAdapter()
        mLinearLayoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        rvFoodType.adapter = mFoodTypeAdapter
        rvFoodType.layoutManager = mLinearLayoutManager

        mRestaurantListAdapter = RestaurantListAdapter(mPresenter)
        mLinearLayoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        rvRestaurantList.adapter = mRestaurantListAdapter
        rvRestaurantList.layoutManager = mLinearLayoutManager
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpAutoCompleteTextView(context: Context){
        val adapter : ArrayAdapter<String> = ArrayAdapter(context,R.layout.autocompletetextview_layout,mRestaurantNameList)
        autoCompleteSearchBox.setAdapter(adapter)
    }

    private fun setUpListener(){
        imgHomeProfile.setOnClickListener {
            startActivity(ProfileActivity.newIntent(it.context))
        }
    }

    override fun setNewRestaurantType(data: List<RestaurantTypeVO>) {
        mFoodTypeAdapter.setNewData(data.toMutableList())
    }

    override fun setNewRestaurantList(data: List<RestaurantVO>) {
        data.forEach {
            mRestaurantNameList.add(it.name)
        }
        mRestaurantListAdapter.setNewData(data.toMutableList())
    }

    override fun navigateToRestaurantDetail(id : Int) {
        activity?.let {
            startActivity(RestaurantDetailActivity.newIntent(it,id))
        }
    }

    override fun showUserProfile(imageUrl: String) {
        if(imageUrl.isNotEmpty()){
            Glide.with(this)
                .load(imageUrl)
                .into(imgHomeProfile)
        }
    }
}