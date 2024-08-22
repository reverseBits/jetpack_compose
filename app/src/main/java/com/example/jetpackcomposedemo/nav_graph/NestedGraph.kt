package com.example.jetpackcomposedemo.nav_graph

import RouteNested
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposedemo.screens.HomeScreen
import com.example.jetpackcomposedemo.screens.LoginScreen
import com.example.jetpackcomposedemo.screens.SignupScreen

@Composable
fun AppNavigationNested(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RouteNested.Auth, // custom type for first screen
    ) {
        AuthGraph(navController)
        AppGraph(navController)

    }
}

fun NavGraphBuilder.AuthGraph(navController: NavController) {

    navigation<RouteNested.Auth>(
        startDestination = RouteNested.Auth.EmailLogIn::class
    ) {
        composable<RouteNested.Auth.EmailLogIn> {
            LoginScreen(onNavigateForward = {
                navController.navigate(
                    RouteNested.Auth.EmailSignUp
                )
            })
        }
        composable<RouteNested.Auth.EmailSignUp>() {
            SignupScreen(onNavigateBack = {
                navController.navigate(
                    RouteNested.App
                ){
                    popUpTo(0)
                }
            })
        }
    }

}


fun NavGraphBuilder.AppGraph(navController: NavController) {
    navigation<RouteNested.App>(
        startDestination = RouteNested.App.Home::class
    ) {
        composable<RouteNested.App.Home> {backStack->
            HomeScreen(onNavigateBack = {
                navController.popBackStack()
            })
        }
    }
}