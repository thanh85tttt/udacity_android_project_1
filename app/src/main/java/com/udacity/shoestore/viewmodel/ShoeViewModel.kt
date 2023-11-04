package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
  private val _shoes = MutableLiveData<MutableList<Shoe>>((mutableListOf()))

  val shoes: LiveData<MutableList<Shoe>>
    get() = _shoes

  fun createShoe(shoe: Shoe) {
    shoe.let {
      _shoes.value?.add(shoe)
    }
  }
}