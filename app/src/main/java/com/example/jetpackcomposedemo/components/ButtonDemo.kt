package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.R

@Composable
fun ButtonDemo(paddingValues: PaddingValues) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        // Filled button
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(Color.Red),
            contentPadding = paddingValues,
            modifier = Modifier.alpha(0.4f),
            border = BorderStroke(width = 1.dp, color = Color.Black)
        ) {
            Text(text = "Filled")
        }

        // Filled Tonal Button
        FilledTonalButton(
            onClick = { },
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 10.dp)
        ) {
            Text(text = "Filled Tonal Button")
        }

        // Outlined button
        OutlinedButton(onClick = { }) {
            Text(text = "Outlined button")
        }

        // Elevated button
        ElevatedButton(
            onClick = { },
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 10.dp,
                disabledElevation = 4.dp
            )
        ) {
            Text(text = "Elevated button")
        }

        // Text button
        TextButton(onClick = { }) {
            Text(text = "Text button")
        }

        // Button with border
        Button(
            onClick = { },
            contentPadding = PaddingValues(10.dp),
            colors = ButtonDefaults.buttonColors(Color.Cyan),
            border = BorderStroke(width = 1.dp, color = Color.Black)
        ) {
            Text(text = "Border Button", color = Color.Black)
        }

        // Button with Image
        Button(
            onClick = { },
            contentPadding = PaddingValues(15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_thumb_up_24),
                contentDescription = "Like button",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(18.dp),
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Yellow)
            )
            Text(text = "Click to Like")
        }
    }
}

@Preview
@Composable
fun ButtonDemoPreview() {
    Scaffold { innerPadding ->
        ButtonDemo(paddingValues = innerPadding)
    }
}