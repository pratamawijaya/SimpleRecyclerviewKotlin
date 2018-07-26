package com.pratamawijaya.androidrecyclerview.item

import android.support.v4.app.FragmentManager
import com.pratamawijaya.androidrecyclerview.R
import com.pratamawijaya.androidrecyclerview.adapter.BannerAdapter
import com.pratamawijaya.androidrecyclerview.domain.BannerPromo
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_carousel_banner.view.btnSemuaPromo
import kotlinx.android.synthetic.main.item_carousel_banner.view.indicator
import kotlinx.android.synthetic.main.item_carousel_banner.view.viewPagerBanner

interface BannerListener {
    fun onSeeAllPromoClick()
    fun onBannerClick(promo: BannerPromo)
}

class BannerCarouselItem(private val banners: List<BannerPromo>,
                         private val supportFragmentManager: FragmentManager,
                         private val listener: BannerListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val viewPagerAdapter = BannerAdapter(supportFragmentManager, banners)
        viewHolder.itemView.viewPagerBanner.adapter = viewPagerAdapter
        viewHolder.itemView.indicator.setViewPager(viewHolder.itemView.viewPagerBanner)

        viewHolder.itemView.btnSemuaPromo.setOnClickListener {
            listener.onSeeAllPromoClick()
        }
    }

    override fun getLayout(): Int = R.layout.item_carousel_banner
}