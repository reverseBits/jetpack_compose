package com.example.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchDataFromAPI()
            RememberCoroutineScopeExample()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FetchDataFromAPI()
    RememberCoroutineScopeExample()
}

// LaunchedEffect example
@Composable
fun FetchDataFromAPI() {
    var data by remember { mutableStateOf("Loading..") }

    LaunchedEffect(Unit) {
        delay(2000)
        data = "Data fetched successfully"
    }
    
    Text(text = data)
}

// rememberCoroutineScope example
@Composable
fun RememberCoroutineScopeExample() {
    var result by remember { mutableStateOf("Tap me") }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = result)
        Button(onClick = {
            scope.launch {
                result = "Task Completed!"
            }
        }) {
            Text(text = "Start Task")
        }
    }
}