package com.AimTrainer.aimtrainer

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("game/{name}/{timer}/{grid}/{navController}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val timer = backStackEntry.arguments?.getString("timer")?.toInt() ?: 0
            val grid = backStackEntry.arguments?.getString("grid")?.toInt() ?: 0
            GameScreen(name, timer, grid, navController)
        }
        composable("result/{name}/{timer}/{score}") {backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val timer = backStackEntry.arguments?.getString("timer")?.toInt() ?: 0
            val score = backStackEntry.arguments?.getString("score")?.toInt() ?: 0
            Result(name, timer, score)
        }
    }
}