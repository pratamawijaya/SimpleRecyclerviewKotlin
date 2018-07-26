package com.pratamawijaya.androidrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.pratamawijaya.androidrecyclerview.domain.BannerPromo
import com.pratamawijaya.androidrecyclerview.domain.Hero
import com.pratamawijaya.androidrecyclerview.item.BannerCarouselItem
import com.pratamawijaya.androidrecyclerview.item.BannerListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.rvMain

class MainActivity : AppCompatActivity(), HeroListener, BannerListener {

    // declare adapter from groupadapter
    private var groupAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val promos = listOf(
                BannerPromo(name = "Puncak badai uang",
                        image = "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
                BannerPromo(
                        name = "hati hati ada guncangan badai uang",
                        image = "https://s4.bukalapak.com/uploads/promo_partnerinfo_bloggy/5042/Bloggy_1.jpg"
                ),
                BannerPromo(name = "Puncak badai uang",
                        image = "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
                BannerPromo(
                        name = "hati hati ada guncangan badai uang",
                        image = "https://s4.bukalapak.com/uploads/promo_partnerinfo_bloggy/5042/Bloggy_1.jpg"
                ),
                BannerPromo(name = "Puncak badai uang",
                        image = "https://s2.bukalapak.com/uploads/promo_partnerinfo_bloggy/2842/Bloggy_1_puncak.jpg"),
                BannerPromo(
                        name = "hati hati ada guncangan badai uang",
                        image = "https://s4.bukalapak.com/uploads/promo_partnerinfo_bloggy/5042/Bloggy_1.jpg"
                )
        )

        rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = groupAdapter
        }

        // declare banner carousel
        val bannerCarouselItem = BannerCarouselItem(promos, supportFragmentManager, this)


        groupAdapter.add(bannerCarouselItem)
    }

    override fun onSeeAllPromoClick() {
        Toast.makeText(this, "se. all promo", Toast.LENGTH_SHORT).show()
    }

    override fun onBannerClick(promo: BannerPromo) {
    }

    override fun onHeroClick(hero: Hero) {
        Toast.makeText(this, "hero clicked ${hero.name}", Toast.LENGTH_SHORT).show()
    }
}
