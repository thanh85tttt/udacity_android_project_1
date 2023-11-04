package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

  private lateinit var welcomeFragmentBinding: WelcomeFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    welcomeFragmentBinding = WelcomeFragmentBinding.inflate(layoutInflater)
    welcomeFragmentBinding.nextButton.setOnClickListener {
      it.findNavController().navigate(
        WelcomeFragmentDirections.actionWelcomeFragmentToInstructorFragment()
      )
    }
    return welcomeFragmentBinding.root
  }
}
