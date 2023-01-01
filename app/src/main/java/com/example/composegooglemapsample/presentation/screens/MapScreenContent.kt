package com.example.composegooglemapsample.presentation.screens

import android.Manifest
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.composegooglemapsample.R
import com.example.composegooglemapsample.permissions.PermissionAction
import com.example.composegooglemapsample.permissions.PermissionDialog
import com.example.composegooglemapsample.presentation.composables.MapView
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

@Composable
fun MapScreenContent(
    snackbarHostState: SnackbarHostState,
    fetchLocationUpdates: () -> Unit
) {

    val scope = rememberCoroutineScope()

    val context = LocalContext.current

    var showMap by rememberSaveable { mutableStateOf(false) }

    PermissionDialog(
        context = context,
        permission = Manifest.permission.ACCESS_FINE_LOCATION,
        permissionRationale = stringResource(id = R.string.permission_location_rationale),
        snackbarHostState = snackbarHostState) { permissionAction ->
        // 5
        when (permissionAction) {
            is PermissionAction.PermissionDenied -> {
                showMap = false
            }
            is PermissionAction.PermissionGranted -> {
                showMap = true
                scope.launch {
                    snackbarHostState.showSnackbar("Location permission granted!")
                }
                fetchLocationUpdates.invoke()
            }
        }
    }

    val currentLocation = LatLng(1.35, 103.87)
    if (showMap) {
        MapView(context, currentLocation)
    }

}