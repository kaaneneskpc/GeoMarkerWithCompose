package com.example.composegooglemapsample.permissions

sealed class PermissionAction {
  object PermissionGranted : PermissionAction()
  object PermissionDenied : PermissionAction()
}
