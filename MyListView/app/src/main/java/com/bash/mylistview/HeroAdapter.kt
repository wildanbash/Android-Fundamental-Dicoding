package com.bash.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var heroes = arrayListOf<Hero>()
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    override fun getItem(i: Int): Any {
        return heroes[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return heroes.size
    }
}

private class ViewHolder constructor(view: View) {
    private val txtName: TextView = view.findViewById(R.id.txt_name)
    private val txtDescription: TextView = view.findViewById(R.id.txt_description)
    private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

    internal fun bind(hero: Hero){
        txtName.text = hero.name
        txtDescription.text = hero.description
        imgPhoto.setImageResource(hero.photo)
    }
}


