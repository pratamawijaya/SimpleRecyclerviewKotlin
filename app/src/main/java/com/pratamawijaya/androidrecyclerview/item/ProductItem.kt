package com.pratamawijaya.androidrecyclerview.item

import com.pratamawijaya.androidrecyclerview.R
import com.pratamawijaya.androidrecyclerview.domain.Product
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_product.view.productImage
import kotlinx.android.synthetic.main.item_product.view.productName

interface ProductListener {
    fun onProductClicked(product: Product)
}

class ProductItem(private val product: Product,
                  private val listener: ProductListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.productName.text = product.name
        Picasso.get().load(product.img).into(viewHolder.itemView.productImage)

        viewHolder.itemView.setOnClickListener {
            listener.onProductClicked(product)
        }
    }

    override fun getLayout(): Int = R.layout.item_product

}