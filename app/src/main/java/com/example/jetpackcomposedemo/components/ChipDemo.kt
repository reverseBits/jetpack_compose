package com.example.jetpackcomposedemo.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChipDemo(padding: PaddingValues) {

    Column {
        AssistChip(
            onClick = { Log.d("Assist chip", "hello world") },
            label = {
                Text(text = "Assist Chip")
            },
            leadingIcon = {
                Icon(Icons.Filled.Settings, contentDescription = "Localized description")
            },
            trailingIcon = {
                Icon(Icons.Filled.Settings, contentDescription = "Localized description")
            },
            modifier = Modifier.padding(start = 15.dp),
            border = BorderStroke(1.dp, color = Color.Cyan)
        )

        FilterChip(
            selected = true,
            onClick = { Log.d("Filter chip", "hello world") },
            label = {
                Text(text = "Filter chip")
            },
            leadingIcon = { Icon(Icons.Filled.Check, contentDescription = "Localized description") }
        )

        InputChip(
            selected = true,
            onClick = { Log.d("Input chip", "hello world") },
            label = {
                Text(text = "Input Chip")
            }
        )

        SuggestionChip(onClick = { Log.d("Suggestion chip", "hello world") },
            label = {
                Text(text = "Suggestion Chip")
            })
    }
}

@Preview
@Composable
fun ChipDemoPreview() {
    Scaffold { innerPadding ->
        ChipDemo(padding = innerPadding)
    }
}