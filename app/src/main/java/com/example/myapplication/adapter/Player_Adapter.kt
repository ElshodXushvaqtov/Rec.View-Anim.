package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Player
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemLayoutBinding

class Player_Adapter(var players: MutableList<Player>, var context: Context):RecyclerView.Adapter<Player_Adapter.MyHolder>() {

    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var item_img=itemView.findViewById<ImageView>(R.id.img)
        var name=itemView.findViewById<TextView>(R.id.item_name)
        var position=itemView.findViewById<TextView>(R.id.position)
        val main=itemView.findViewById<ConstraintLayout>(R.id.player_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var index=players[position]
       holder.item_img.setImageResource(index.img)
        holder.name.text=index.name
        holder.position.text=index.position

        val anim = AnimationUtils.loadAnimation(context,R.anim.player_anim)
        holder.main.startAnimation(anim)
    }

}