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
            CountryApp()
        }
        composable("africa") {
            // Affichage de l'écran pour l'Afrique
        }
    }
}

