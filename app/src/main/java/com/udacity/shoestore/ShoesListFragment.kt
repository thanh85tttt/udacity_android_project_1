package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.databinding.ShoesListFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel

class ShoesListFragment : Fragment() {

  private lateinit var shoesListBinding: ShoesListFragmentBinding
  private val shoeViewModel: ShoeViewModel by activityViewModels()

  private fun setListeners() {
    shoesListBinding.addShoesButton.setOnClickListener {
      it.findNavController().navigate(
        ShoesListFragmentDirections.actionShoesListFragmentToShoeDetailFragment()
      )
    }
    shoeViewModel.shoes.observe(viewLifecycleOwner, this::addItemShoeToShoeListLayout)
  }

  private fun setMenuProvider() {
    requireActivity().addMenuProvider(object : MenuProvider {
      override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.app_menu, menu)
      }

      override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
          R.id.logout_item -> {
            findNavController().navigate(
              ShoesListFragmentDirections.actionShoesListFragmentToLoginFragment()
            )
            true
          }

          else -> false
        }
      }
    }, viewLifecycleOwner, Lifecycle.State.RESUMED)
  }


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    shoesListBinding = DataBindingUtil.inflate(
      inflater, R.layout.shoes_list_fragment, container, false
    )
    setListeners()
    setMenuProvider()
    return shoesListBinding.root
  }

  private fun addItemShoeToShoeListLayout(shoes: List<Shoe>) {
    shoesListBinding.shoesListLayout.removeAllViews()
    val layoutInflater = layoutInflater
    shoes.forEach { shoe ->
      val itemShoeBinding = DataBindingUtil.inflate(
        layoutInflater,
        R.layout.item_shoe,
        null,
        false
      ) as ItemShoeBinding
      itemShoeBinding.itemShoe = shoe
      itemShoeBinding.size.text = shoe.getSize()
      shoesListBinding.shoesListLayout.addView(itemShoeBinding.root)
    }
  }
}
