package com.nhz.happy_delivery_app_by_nhz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.activities.LoginActivity
import com.nhz.happy_delivery_app_by_nhz.activities.ProfileActivity
import com.nhz.happy_delivery_app_by_nhz.activities.RestaurantDetailActivity
import com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview.NewRestaurantAdapter
import com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview.PopularChoiceAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantTypeVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.delegates.RestaurantDelegate
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.HomePresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.HomePresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.HomeView
import com.nhz.happy_delivery_app_by_nhz.views.viewholders.recyclerview.PopularChoiceViewHolder
import kotlinx.android.synthetic.main.fragment_home2.*

class HomeFragment2 : Fragment(),HomeView {

    private lateinit var mPopularChoiceAdapter : PopularChoiceAdapter
    private lateinit var mNewRestaurantAdapter : NewRestaurantAdapter
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mPresenter : HomePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpRecyclerView()
        activity?.let {
            mPresenter.onUiReady(this,it)
            imgMenu.setOnClickListener {
                startActivity(ProfileActivity.newIntent(it.context))
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    private fun setUpRecyclerView(){
        mPopularChoiceAdapter = PopularChoiceAdapter(mPresenter)
        mLinearLayoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        rvPopularChoices.adapter = mPopularChoiceAdapter
        rvPopularChoices.layoutManager = mLinearLayoutManager

        mNewRestaurantAdapter = NewRestaurantAdapter(mPresenter)
        mLinearLayoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        rvNewRestaurants.adapter = mNewRestaurantAdapter
        rvNewRestaurants.layoutManager = mLinearLayoutManager
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun setNewRestaurantType(data: List<RestaurantTypeVO>) {

    }

    override fun setNewRestaurantList(data: List<RestaurantVO>) {
        mNewRestaurantAdapter.setNewData(data.toMutableList())
        mPopularChoiceAdapter.setNewData(data.toMutableList())
    }

    override fun navigateToRestaurantDetail(id : Int) {
        activity?.let {
            startActivity(RestaurantDetailActivity.newIntent(it,id))
        }
    }

}