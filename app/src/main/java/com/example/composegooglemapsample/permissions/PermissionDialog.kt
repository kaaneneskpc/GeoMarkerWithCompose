package com.example.composegooglemapsample.permissions

import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import com.example.composegooglemapsample.utils.checkIfPermissionGranted
import com.example.composegooglemapsample.utils.shouldShowPermissionRationale

@Composable
fun PermissionDialog(
    context: Context,
    permission: String,
    permissionRationale: String,
    snackbarHostState: SnackbarHostState,
    permissionAction: (PermissionAction) -> Unit
) {

  val isPermissionGranted = checkIfPermissionGranted(context, permission)

  if (isPermissionGranted) {
    permissionAction(PermissionAction.PermissionGranted)
    return
  }

  val permissionsLauncher = rememberLauncherForActivityResult(
      ActivityResultContracts.RequestPermission()
  ) { isGranted: Boolean ->
    if (isGranted) {
      permissionAction(PermissionAction.PermissionGranted)
    } else {
      permissionAction(PermissionAction.PermissionDenied)
    }
  }

  val showPermissionRationale = shouldShowPermissionRationale(context, permission)

  if (showPermissionRationale) {
    LaunchedEffect(showPermissionRationale) {

      val snackbarResult = snackbarHostState.showSnackbar(
          message = permissionRationale,
          actionLabel = "Grant Access",
          duration = SnackbarDuration.Long

      )
      when (snackbarResult) {
        SnackbarResult.Dismissed -> {
          permissionAction(PermissionAction.PermissionDenied)
        }
        SnackbarResult.ActionPerformed -> {
          permissionsLauncher.launch(permission)
        }
      }
    }
  } else {
    SideEffect {
      permissionsLauncher.launch(permission)
    }

  }
}