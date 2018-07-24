package com.pratamawijaya.androidrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pratamawijaya.androidrecyclerview.domain.Hero
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hero.view.imgHeroes
import kotlinx.android.synthetic.main.item_hero.view.txtHeroName

class HeroAdapter(private val heroes: List<Hero>,
                  private val listener: HeroListener) : RecyclerView.Adapter<HeroHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): HeroHolder {
        return HeroHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_hero, viewGroup, false))
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.bindHero(heroes[position], listener)
    }
}

interface HeroListener {
    fun onHeroClick(hero: Hero)
}

class HeroHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvHeroName = view.txtHeroName
    private val imgHero = view.imgHeroes

    fun bindHero(hero: Hero, listener: HeroListener) {
        tvHeroName.text = hero.name
        Picasso.get().load(hero.image).into(imgHero)

        itemView.setOnClickListener { listener.onHeroClick(hero) }
    }
}