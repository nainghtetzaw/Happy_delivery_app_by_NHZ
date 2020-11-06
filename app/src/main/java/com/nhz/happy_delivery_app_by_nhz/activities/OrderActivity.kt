package com.nhz.happy_delivery_app_by_nhz.activities

import android.content.Context
import android.content.Intent
import android.content.LocusId
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.adapters.recyclerview.OrderAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.OrderedFoodListVO
import com.nhz.happy_delivery_app_by_nhz.data.vos.RestaurantVO
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.impls.OrderFoodPresenterImpl
import com.nhz.happy_delivery_app_by_nhz.mvp.presenters.interfaces.OrderFoodPresenter
import com.nhz.happy_delivery_app_by_nhz.mvp.views.OrderFoodView
import com.nhz.happy_delivery_app_by_nhz.views.bottomsheet.CheckInBtnSheet
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.restaurant_profile_layout.*

class OrderActivity : AppCompatActivity(),OrderFoodView {

    private lateinit var mAdapter : OrderAdapter
    private lateinit var mLinearLayoutManager : LinearLayoutManager
    private lateinit var mPresenter : OrderFoodPresenter

    companion object{

        const val RESTAURANT_ID = "RESTAURANT_ID"

        fun newIntent(context: Context,id: Int) : Intent{
            return  Intent(context,OrderActivity::class.java).putExtra(RESTAURANT_ID,id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setUpPresenter()
        setUpRecyclerView()
        imgOrderBack.setOnClickListener { finish() }

        val id = intent.getIntExtra(RESTAURANT_ID,0)
        mPresenter.onUiReady(this,id)

        btnCheckOut.setOnClickListener {
            mPresenter.deleteOrderedFoodList(id)
            CheckInBtnSheet().apply {
                show(supportFragmentManager,tag)
            }
        }
    }

    private fun setUpRecyclerView(){
        mAdapter = OrderAdapter()
        mLinearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvOrder.adapter = mAdapter
        rvOrder.layoutManager = mLinearLayoutManager
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(OrderFoodPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun showEmptyView(){
        vpEmpty.visibility = View.VISIBLE
    }

    override fun hideEmptyView(){
        vpEmpty.visibility = View.GONE
    }

    override fun hideOrderView() {
        nestedScrollView.visibility = View.GONE
    }

    override fun showOrderedFoods(data: List<OrderedFoodListVO>, restaurant: RestaurantVO) {
        mAdapter.setNewData(data.toMutableList())

        var subTotal = 0
        data.forEach {
            subTotal += (it.price * it.quantity)
        }

        Glide.with(this)
            .load(restaurant.image)
            .into(imgRestaurantProfile)
        tvOrderSubtotalAmount.text = "$$subTotal"
        tvRestaurantProfileName.text = restaurant.name
        tvRestaurantProfileType.text = "${restaurant.food_type} - ${restaurant.restaurant_type} - $$"
        tvRestaurantProfileRating.text = restaurant.rating.toString()
        tvRestaurantProfileRatingAmount.text = "(${restaurant.rating_amount})"
    }

}