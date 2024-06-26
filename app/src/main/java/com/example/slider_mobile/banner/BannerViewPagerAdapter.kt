package com.example.slider_mobile.banner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.slider_mobile.R

class BannerViewPagerAdapter(private val context: Context) : PagerAdapter() {

    private var list = mutableListOf(
        R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_3,
        R.drawable.banner_4, R.drawable.banner_5,
    )
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(context).inflate(R.layout.listitem_icon, null, false)

        // 여기서 item에 적용할 코드를 작성해주세요.
        val imageView = view.findViewById<ImageView>(R.id.imageView_icon)
        imageView.setImageResource(list[position])

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    // 0f ~ 1f 사이의 값을 입력해 한 화면에 보일 item의 개수를 조절해주세요.
    // Enter a value between 0f and 1f to adjust the number of items to be displayed on one screen.
    override fun getPageWidth(position: Int): Float {
        return 0.8f
    }
}