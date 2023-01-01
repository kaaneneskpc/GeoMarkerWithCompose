package com.example.composegooglemapsample.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composegooglemapsample.presentation.GeoMarkerViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.example.composegooglemapsample.presentation.composables.GeoMarkerButton
import com.example.composegooglemapsample.presentation.composables.GeoMarkerTopBar
import com.example.composegooglemapsample.presentation.composables.SaveGeoPoint


@ExperimentalMaterial3Api
@Composable
fun GeoMarkerScreen(
    geoMarkerViewModel: GeoMarkerViewModel
) {
    val context = LocalContext.current
    var areaPoints = mutableListOf<LatLng>()
    var drawPolygon by remember {
        mutableStateOf(false)
    }

    val currentLocation by geoMarkerViewModel.currentLatLng.collectAsState()

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLocation, 16f)
    }

    var showSavePoint by remember {
        mutableStateOf(false)
    }

    var clickedLocation by remember {
        mutableStateOf(LatLng(0.0, 0.0))
    }

    Scaffold(
        topBar = { GeoMarkerTopBar() },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState,
                    onMapClick = {
                        drawPolygon.takeIf { !it }.apply {
                            showSavePoint = true
                            clickedLocation = it
                        }
                    }
                ) {

                    if (drawPolygon && areaPoints.isNotEmpty()) {

                        areaPoints.forEach {
                            Marker(state = MarkerState(position = it))
                        }


                        Polygon(
                            points = areaPoints,
                            fillColor = Color.Blue,
                            strokeColor = Color.Blue
                        )
                    }

                    if (showSavePoint) {
                        Marker(state = MarkerState(position = clickedLocation))
                    }
                }

                if (showSavePoint) {
                    SaveGeoPoint(latLng = clickedLocation) {
                        showSavePoint = it.hideSavePointUi
                        areaPoints.add(it.point)
                    }
                } else {
                    if (areaPoints.isEmpty()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Color.Blue,
                            text = "Click any point on the map to mark it.",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            GeoMarkerButton(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 16.dp),
                drawPolygon = drawPolygon,
                areaPoints = areaPoints
            ) { drawPolygonCallback ->
                drawPolygon = drawPolygonCallback
                if (!drawPolygonCallback) {
                    areaPoints = mutableListOf()
                }
            }
        }
    )
}