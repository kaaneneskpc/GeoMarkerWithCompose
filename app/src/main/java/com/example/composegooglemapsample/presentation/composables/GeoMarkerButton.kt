package com.example.composegooglemapsample.presentation.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng

@Composable
fun GeoMarkerButton(
    modifier: Modifier,
    drawPolygon: Boolean,
    areaPoints: MutableList<LatLng>,
    callback: (Boolean) -> Unit) {
  Button(
      onClick = {
        if (drawPolygon) {
          callback(false)
        } else {
          callback(true)
        }
      },
      modifier = modifier,
      enabled = areaPoints.isNotEmpty() && areaPoints.size > 2
  ) {
    Icon(
        imageVector = if (drawPolygon) Icons.Filled.Refresh else Icons.Filled.Check,
        contentDescription = "Complete",
        modifier = Modifier.size(ButtonDefaults.IconSize)
    )
    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
    Text(text = if (drawPolygon) "Retry" else "Complete")
  }
}