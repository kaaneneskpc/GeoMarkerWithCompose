package com.example.composegooglemapsample.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composegooglemapsample.ui.theme.ComposeGeoMarkerTheme

@Composable
fun GeoMarkerTopBar() {
  SmallTopAppBar(
      title = { Text("Geo Marker") },
      modifier = Modifier
          .background(color = MaterialTheme.colorScheme.inversePrimary)
  )
}

@Preview
@Composable
fun TopBarPreview() {
  ComposeGeoMarkerTheme() {
    GeoMarkerTopBar()
  }
}