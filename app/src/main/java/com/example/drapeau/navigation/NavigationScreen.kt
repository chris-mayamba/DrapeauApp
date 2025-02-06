@file:Suppress("UNUSED_EXPRESSION")

package com.example.drapeau.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.drapeau.DrapeauApp
import com.example.drapeau.HomeScreen


@Composable
fun NavigationScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onClick = { navController.navigate("flag") })
        }

        composable("flag") {
            DrapeauApp()
        }
    }
}
