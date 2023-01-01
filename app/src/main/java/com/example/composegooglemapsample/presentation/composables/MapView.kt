package com.example.composegooglemapsample.presentation.composables

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.example.composegooglemapsample.R
import com.google.android.gms.maps.model.MapStyleOptions


@Composable
fun MapView(context: Context, location: LatLng) {

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location, 16f)
    }

    val infoWindowState = rememberMarkerState(position = location)

    val mapProperties by remember {
        mutableStateOf(
            MapProperties(
                mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context, R.raw.map_style)
            )
        )
    }


    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = mapProperties
    ) {
        Marker(
            state = MarkerState(position = location),
        )
        MarkerInfoWindow(
            state = infoWindowState,
            title = "My location",
            snippet = "Hello :)",
            content = {
                CustomInfoWindow(title = it.title, description = it.snippet)
            }
        )
        Circle(
            center = location,
            fillColor = MaterialTheme.colorScheme.secondaryContainer,
            strokeColor = MaterialTheme.colorScheme.secondaryContainer,
            radius = 300.00
        )
    }
}