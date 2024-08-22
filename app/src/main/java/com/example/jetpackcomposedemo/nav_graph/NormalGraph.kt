package com.example.jetpackcomposedemo.nav_graph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.jetpackcomposedemo.routes.CustomNavType
import com.example.jetpackcomposedemo.routes.Routes
import com.example.jetpackcomposedemo.routes.ScreenInfo
import com.example.jetpackcomposedemo.screens.FirstScreen
import com.example.jetpackcomposedemo.screens.SecondScreen
import kotlin.reflect.typeOf


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.FirstScreenMy, // custom type for first screen
    ) {
        composable<Routes.FirstScreenMy> { // custom type as generic
            FirstScreen(onNavigateForward = {
                // passing object for seconds class
                navController.navigate(
                    Routes.SecondScreenMy(customPrimitive = "Custom primitive string" , screenInfo = ScreenInfo(route = "", id = 10))
                )
            })
        }
        composable<Routes.SecondScreenMy>(typeMap =  mapOf(typeOf<ScreenInfo>() to CustomNavType(ScreenInfo::class.java, ScreenInfo.serializer()))) { backstackEntry ->
            // unpacking the back stack entry to obtain our value
            val customValue = backstackEntry.toRoute<Routes.SecondScreenMy>()
            Log.i("SecondScreen", customValue.customPrimitive)
            SecondScreen(onNavigateBack = {
//                navController.popBackStack()
                navController.navigate(
                    Routes.FirstScreenMy
                )
            })
        }
    }
}