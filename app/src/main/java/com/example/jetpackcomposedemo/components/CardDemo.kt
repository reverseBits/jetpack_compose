package com.example.jetpackcomposedemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardDemo(paddingValues: PaddingValues) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        // Normal rectangle card
        Card(
            onClick = { },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = Color.Black
            ),
            shape = RectangleShape,
            modifier = Modifier.size(width = 150.dp, height = 100.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Text(
                text = "Card with elevation",
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // ElevatedCard with rounded corners
        ElevatedCard(
            onClick = {},
            shape = RoundedCornerShape(8),
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Text(
                text = "Hello! This is example of elevated card in Android jetpack compose",
                modifier = Modifier.padding(8.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "This is another big text for texting the space of card according to content",
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Card with border
        OutlinedCard(
            onClick = {},
            border = BorderStroke(width = 1.dp, color = Color.Black),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            ),
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Text(
                text = "Hello! This is an example of elevated card in Android jetpack compose",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun CardDemoPreview() {
    Scaffold { padding ->
        CardDemo(padding)
    }
}