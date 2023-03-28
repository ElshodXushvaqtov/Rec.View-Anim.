package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.adapter.Player_Adapter
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var list= mutableListOf<Player>()
        for (i in 0..10){
        list.add(Player("Messi","Attacking Midfielder",R.drawable.messi))
        list.add(Player("Pique","Center Back",R.drawable.pique))
        list.add(Player("Mbappe","Right Winger",R.drawable.mbappe))
        list.add(Player("Ronaldo","Center Forward",R.drawable.ronaldo))
    }
        binding.rv.adapter=Player_Adapter(list,this)

    }
}