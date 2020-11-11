package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel :ViewModel(){


     val shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        shoeList.value = ArrayList()
    }

    fun addShoe( name: String,  size: String,  company: String,  description: String) {
        var shoe:Shoe= Shoe(name, size, company, description)
        shoeList.value?.add(shoe)
        shoeList.value = shoeList.value

    }

    fun addDummyData(){
        addShoe("Adidas", "9", "Adidas", "Great shoes")
        addShoe("Pumaaaaaaaa", "9", "Adidas", "Great shoes")

    }



}