package com.example.jetpackcomposedemo.routes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class ScreenInfo(val route: String, val id: Int) : Parcelable

@Serializable
sealed class Routes{

    @Serializable
    data object FirstScreenMy : Routes() // pure data object without any primitive

    @Serializable
    data class SecondScreenMy(val customPrimitive: String,val screenInfo: ScreenInfo) : Routes() // data class with custom primitive
}