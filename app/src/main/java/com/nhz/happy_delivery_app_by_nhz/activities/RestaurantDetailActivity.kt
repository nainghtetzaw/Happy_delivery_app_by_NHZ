package com.nhz.happy_delivery_app_by_nhz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview.FoodAdapter
import com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview.PopularFoodAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.RestaurantDetailPresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.RestaurantDetailPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.RestaurantDetailView
import kotlinx.android.synthetic.main.activity_restaurant_detail.*

class RestaurantDetailActivity : AppCompatActivity(),RestaurantDetailView {

    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mPopularFoodAdapter : PopularFoodAdapter
    private lateinit var mFoodAdapter : FoodAdapter
    private lateinit var mPresenter : RestaurantDetailPresenter
    private var mRestaurantDetailData : RestaurantVO = RestaurantVO()

    companion object{
        const val RESTAURANT_ID = "RESTAURANT_ID"

        fun newIntent(context: Context?,id : Int) : Intent{
            return  Intent(context,RestaurantDetailActivity::class.java).putExtra(RESTAURANT_ID,id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)
        setUpPresenter()
        setUpRecyclerView()

        val id : Int = intent.getIntExtra(RESTAURANT_ID,0)
        mPresenter.onUiReady(this,id)

        imgDetailBack.setOnClickListener { finish() }
        imgFavorite.setOnClickListener { startActivity(OrderActivity.newIntent(this,mRestaurantDetailData.id)) }

    }

    private fun setUpRecyclerView(){
        mLinearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mPopularFoodAdapter = PopularFoodAdapter(mPresenter)
        rvPopularBurgerList.layoutManager = mLinearLayoutManager
        rvPopularBurgerList.adapter = mPopularFoodAdapter

        mLinearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mFoodAdapter = FoodAdapter()
        rvFoodList.layoutManager = mLinearLayoutManager
        rvFoodList.adapter = mFoodAdapter
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(RestaurantDetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun setNewData(data: RestaurantVO) {
        mRestaurantDetailData = data
        Glide.with(this)
            .load(data.image)
            .into(imgRestaurantDetail)
        tvRestaurantDetailName.text = data.name
        tvDetailRating.text = data.rating.toString()
        tvDetailRatingAmount.text = "(${data.rating_amount}) - ${data.food_type} - ${data.restaurant_type} - $$"
        tvDetailLocation.text = data.location
        tvDetailFoodType.text = data.food_type

        mPopularFoodAdapter.setNewData(data.food_list)
        mFoodAdapter.setNewData(data.food_list)
    }

    override fun addOrderFood() : RestaurantVO {
        Toast.makeText(this,"Food Added",Toast.LENGTH_SHORT).show()
        return mRestaurantDetailData
    }
}