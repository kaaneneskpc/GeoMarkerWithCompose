package com.example.composegooglemapsample.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composegooglemapsample.presentation.composables.GeoMarkerTopBar
import com.example.composegooglemapsample.presentation.navigation.Screens

@ExperimentalMaterial3Api
@Composable
fun MapsScreen(
    snackbarHostState: SnackbarHostState,
    navController: NavController,
    fetchLocationUpdates: () -> Unit
) {
  Scaffold(
      topBar = { GeoMarkerTopBar() },
      content = { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
          MapScreenContent(snackbarHostState, fetchLocationUpdates)
          SnackbarHost(
              hostState = snackbarHostState,
              modifier = Modifier
                  .wrapContentHeight(Alignment.Bottom)
                  .align(Alignment.BottomCenter)
          )
        }
      },
      floatingActionButton = {
        ExtendedFloatingActionButton(
            modifier = Modifier
                .padding(16.dp),
            onClick = {
              navController.navigate(Screens.GeoMarkerScreen.route)
            },
            icon = {
              Icon(
                  Icons.Filled.Add,
                  contentDescription = "Create"
              )
            },
            text = { Text("Mark Area") }
        )
      }
  )
}