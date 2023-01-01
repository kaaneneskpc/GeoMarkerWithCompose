package com.example.composegooglemapsample.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composegooglemapsample.ui.theme.ComposeGeoMarkerTheme

@Composable
fun CustomInfoWindow(title: String?, description: String?) {
  Column(
      modifier = Modifier
          .wrapContentWidth()
          .background(Color.DarkGray)
  ) {
    Text(
        title ?: "Title",
        color = Color.White,
        modifier = Modifier
            .padding(6.dp)
    )
    Text(
        description ?: "Description",
        color = Color.White,
        modifier = Modifier
            .padding(6.dp)
    )
  }
}

@Preview
@Composable
fun CustomInfoWindowPreview() {
  ComposeGeoMarkerTheme {
    CustomInfoWindow(title = "Test", description = "Test here and there")
  }
}