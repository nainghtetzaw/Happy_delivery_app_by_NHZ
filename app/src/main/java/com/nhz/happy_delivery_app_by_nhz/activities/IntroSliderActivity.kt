package com.nhz.happy_delivery_app_by_nhz.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.nhz.happy_delivery_app_by_nhz.R
import com.nhz.happy_delivery_app_by_nhz.adapters.viewpager.IntroSliderAdapter
import com.nhz.happy_delivery_app_by_nhz.data.vos.IntroSliderVO
import kotlinx.android.synthetic.main.activity_intro_slider.*

class IntroSliderActivity : AppCompatActivity() {

    private val mAdapter : IntroSliderAdapter = IntroSliderAdapter()
    private lateinit var mDotLayout : LinearLayout
    private val mDot : MutableList<TextView> = mutableListOf()

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,IntroSliderActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_slider)
        mDotLayout = findViewById(R.id.dotsLayout)
        setUpViewPagerAndIndicatorAndListener()

        btnCreateAccount.setOnClickListener { startActivity(SignUpActivity.newIntent(this)) }
        tvIntroLogin.setOnClickListener { startActivity(LoginActivity.newIntent(this)) }

    }

    private fun setUpViewPagerAndIndicatorAndListener(){
        mAdapter.setNewData(mutableListOf(
            IntroSliderVO(
                R.drawable.food_delivery_vector,
                "Find foods you love",
                "Discover the best foods from over 1,000 restaurants."
            ),
            IntroSliderVO(
                R.drawable.fast_delivery_vector,
                "Fast Delivery",
                "Fast delivery to your home, office and wherever you are."
            ),
            IntroSliderVO(
                R.drawable.track_delivery_process_vector,
                "Live Tracking",
                "Real time tracking of your food on the app after ordered."
            )
        ))
        vpIntro.adapter = mAdapter

        for(i in 0..2 ) {
            mDot.add(TextView(this))
            mDot[i].text = Html.fromHtml("&#8226")
            mDot[i].setTextColor(resources.getColor(R.color.color_transparent))
            mDot[i].textSize = 35f
            mDotLayout.addView(mDot[i])
        }

        vpIntro.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val childcount = mDotLayout.childCount
                for(i in 0 until childcount){
                    if(i == position){
                        mDot[i].setTextColor(resources.getColor(R.color.color_pink))
                    }else {
                        mDot[i].setTextColor(resources.getColor(R.color.color_transparent))
                    }
                }
            }
        })
    }
}