package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.Player_Adapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ItemLayoutBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        var binding2=ItemLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var list = mutableListOf<Player>()
        for (i in 0..10) {
            list.add(Player("Messi", "Attacking Midfielder", R.drawable.messi))
            list.add(Player("Pique", "Center Back", R.drawable.pique))
            list.add(Player("Mbappe", "Right Winger", R.drawable.mbappe))
            list.add(Player("Ronaldo", "Center Forward", R.drawable.ronaldo))
        }

        val adapter = Player_Adapter(list, this)
        val itemTouchHelper = object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val dragFlags = UP or DOWN or START or END
                val swipeFlags = START or END
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                binding2.viewBg.setBackgroundColor(Color.parseColor("#121212"))
                adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                adapter.onItemDelete(viewHolder.adapterPosition)
            }
        }
        val itemTouch = ItemTouchHelper(itemTouchHelper)
        itemTouch.attachToRecyclerView(binding.rv)
        binding.rv.adapter = adapter
    }
}