package com.example.composegooglemapsample.presentation

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GeoMarkerViewModel : ViewModel() {

  private val _currentLatLng = MutableStateFlow(LatLng(0.0, 0.0))
  val currentLatLng: StateFlow<LatLng> get() = _currentLatLng

  fun setCurrentLatLng(latLng: LatLng) {
    _currentLatLng.value = latLng
  }
}