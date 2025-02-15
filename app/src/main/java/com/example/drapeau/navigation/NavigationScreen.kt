@file:Suppress("UNUSED_EXPRESSION")

package com.example.drapeau.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.drapeau.DrapeauApp
import com.example.drapeau.HomeScreen
import com.example.drapeau.ui.theme.CountryApp


@Composable
fun NavigationScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToCountries = { navController.navigate("flag") },
                onNavigateToAfrica = { navController.navigate("africa") }
            )
        }
        composable("flag") {
            CountryApp(region = null) // Affiche tous les pays
        }
        composable("africa") {
            CountryApp(region = "africa") // Affiche uniquement les pays d'Afrique
        }
    }
}


