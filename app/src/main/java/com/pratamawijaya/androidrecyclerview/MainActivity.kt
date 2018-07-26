package com.pratamawijaya.androidrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.pratamawijaya.androidrecyclerview.domain.BannerPromo
import com.pratamawijaya.androidrecyclerview.domain.Hero
import com.pratamawijaya.androidrecyclerview.domain.Product
import com.pratamawijaya.androidrecyclerview.item.BannerCarouselItem
import com.pratamawijaya.androidrecyclerview.item.BannerListener
import com.pratamawijaya.androidrecyclerview.item.ProductCategoryItem
import com.pratamawijaya.androidrecyclerview.item.ProductItem
import com.pratamawijaya.androidrecyclerview.item.ProductListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_main.rvMain

class MainActivity : AppCompatActivity(), HeroListener, BannerListener, ProductListener {

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

        val products = listOf(
                Product(name = "Steam",
                        img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
                Product(name = "Starbucks",
                        img = "https://news.starbucks.com/uploads/images/Logo/_preview/Starbucks_Logo_Hi-res.jpg"),
                Product(name = "Steam",
                        img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
                Product(name = "Starbucks",
                        img = "https://news.starbucks.com/uploads/images/Logo/_preview/Starbucks_Logo_Hi-res.jpg"),
                Product(name = "Steam",
                        img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
                Product(name = "Starbucks",
                        img = "https://news.starbucks.com/uploads/images/Logo/_preview/Starbucks_Logo_Hi-res.jpg"),
                Product(name = "Steam",
                        img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
                Product(name = "Starbucks",
                        img = "https://news.starbucks.com/uploads/images/Logo/_preview/Starbucks_Logo_Hi-res.jpg"),
                Product(name = "Steam",
                        img = "http://www.stickpng.com/assets/images/58aefdc2c869e092af51ee6f.png"),
                Product(name = "Starbucks",
                        img = "https://news.starbucks.com/uploads/images/Logo/_preview/Starbucks_Logo_Hi-res.jpg")
        )



        rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = groupAdapter
        }

        // declare banner carousel
        val bannerCarouselItem = BannerCarouselItem(promos, supportFragmentManager, this)
        groupAdapter.add(bannerCarouselItem)

        Section().apply {
            add(makeProductCategory(products))
            groupAdapter.add(this)
        }
    }

    private fun makeProductCategory(products: List<Product>): ProductCategoryItem {
        val productItemGroupAdapter = GroupAdapter<ViewHolder>()
        products.map {
            productItemGroupAdapter.add(ProductItem(it, this))
        }
        return ProductCategoryItem(productItemGroupAdapter)
    }

    override fun onProductClicked(product: Product) {
        Toast.makeText(this, "clicked ${product.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onSeeAllPromoClick() {
        Toast.makeText(this, "see all promo", Toast.LENGTH_SHORT).show()
    }

    override fun onBannerClick(promo: BannerPromo) {
    }

    override fun onHeroClick(hero: Hero) {
        Toast.makeText(this, "hero clicked ${hero.name}", Toast.LENGTH_SHORT).show()
    }
}
