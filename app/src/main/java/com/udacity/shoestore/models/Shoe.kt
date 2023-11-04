package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(private var name: String, private var size: Double, private var company: String, private var description: String) :
  Parcelable, BaseObservable() {

  @Bindable
  fun getName(): String {
    return name
  }

  fun setName(value: String) {
    name = value
  }

  @Bindable
  fun getCompany(): String {
    return company
  }

  fun setCompany(value: String) {
    company = value
  }

  @Bindable
  fun getDescription(): String {
    return description
  }

  fun setDescription(value: String) {
    description = value
  }

  @Bindable
  fun getSize(): String {
    return size.toString()
  }

  fun setSize(value: String) {
    if (value.isEmpty()) {
      size = 0.0
      return
    }
    size = value.toDouble()
  }
}
