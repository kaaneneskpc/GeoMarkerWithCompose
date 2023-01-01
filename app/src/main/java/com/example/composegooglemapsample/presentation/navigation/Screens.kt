package com.example.composegooglemapsample.presentation.navigation

sealed class Screens(val route: String) {
  object MapScreen : Screens("mapsScreen")
  object GeoMarkerScreen : Screens("geoMarkerScreen")
}