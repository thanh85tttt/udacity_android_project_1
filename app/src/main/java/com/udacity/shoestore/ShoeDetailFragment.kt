package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel

class ShoeDetailFragment : Fragment() {

  private lateinit var shoeDetailBinding: ShoeDetailFragmentBinding
  private val shoeViewModel: ShoeViewModel by activityViewModels()

  private fun addNewShoe() {
    val newShoe = Shoe(
      shoeDetailBinding.nameEdittext.text.toString(),
      shoeDetailBinding.companyEdittext.text.toString().toDouble(),
      shoeDetailBinding.sizeEdittext.text.toString(),
      shoeDetailBinding.descriptionEdittext.text.toString()
    )
    shoeViewModel.createShoe(newShoe)
  }

  private fun navigateToShoesList() {
    val direction = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoesListFragment()
    requireView().findNavController().navigate(direction)
  }

  private fun setupListeners() {
    shoeDetailBinding.cancelButton.setOnClickListener {
      addNewShoe()
      navigateToShoesList()
    }
    shoeDetailBinding.saveButton.setOnClickListener {
      navigateToShoesList()
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    shoeDetailBinding = DataBindingUtil.inflate(
      inflater, R.layout.shoe_detail_fragment, container, false
    )
    setupListeners()
    return shoeDetailBinding.root
  }
}