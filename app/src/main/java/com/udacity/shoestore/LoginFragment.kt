package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

  private lateinit var loginBinding: LoginFragmentBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    loginBinding = LoginFragmentBinding.inflate(layoutInflater)
    loginBinding.signInButton.setOnClickListener {
      it.findNavController().navigate(
        LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
      )
    }
    return loginBinding.root
  }
}
