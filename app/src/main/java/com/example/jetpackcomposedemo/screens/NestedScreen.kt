package com.example.jetpackcomposedemo.screens


import androidx.compose.runtime.Composable


@Composable
fun LoginScreen(onNavigateForward: () -> Unit) {
    SimpleScreen(text = "Login Screen", textButton = "Go Signup") {
        onNavigateForward()
    }
}

@Composable
fun SignupScreen(onNavigateBack: () -> Unit) {
    SimpleScreen(text = "Signup Screen", textButton = "Go Home") {
        onNavigateBack()
    }
}

@Composable
fun HomeScreen(onNavigateBack: () -> Unit) {
    SimpleScreen(text = "Home Screen", textButton = "Go back") {
        onNavigateBack()
    }
}

