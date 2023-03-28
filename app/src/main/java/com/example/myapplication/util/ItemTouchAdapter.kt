package com.example.myapplication.util

interface ItemTouchAdapter {

    fun onItemMove(fromPosition:Int,toPosition:Int)

    fun onItemDelete(position:Int)

}