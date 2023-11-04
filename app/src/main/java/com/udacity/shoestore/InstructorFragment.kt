package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.InstructorFragmentBinding

class InstructorFragment : Fragment() {

  private lateinit var instructorFragmentBinding: InstructorFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    instructorFragmentBinding = InstructorFragmentBinding.inflate(layoutInflater)
    instructorFragmentBinding.listShowButton.setOnClickListener {
      it.findNavController().navigate(
        InstructorFragmentDirections.actionInstructorFragmentToShoesListFragment()
      )
    }

    return instructorFragmentBinding.root
  }
}
