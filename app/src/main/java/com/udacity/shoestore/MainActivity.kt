package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var appBarConfig: AppBarConfiguration

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
      this,
      R.layout.activity_main
    )
    val navController = this.findNavController(R.id.shoe_nav_host_fragment)
    NavigationUI.setupActionBarWithNavController(this, navController)
    appBarConfig = AppBarConfiguration(navController.graph)
    NavigationUI.setupWithNavController(binding.shoeNavView, navController)
  }

  override fun onSupportNavigateUp(): Boolean {
    val navController = this.findNavController(R.id.shoe_nav_host_fragment)
    return NavigationUI.navigateUp(navController, appBarConfig)
  }
}
