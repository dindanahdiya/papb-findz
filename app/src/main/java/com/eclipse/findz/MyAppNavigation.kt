package com.eclipse.findz

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eclipse.findz.screen.HomeScreen
import com.eclipse.findz.screen.LoginScreen
import com.eclipse.findz.screen.RegisterInfluencerScreen
import com.eclipse.findz.screen.RegisterScreen
import com.eclipse.findz.screen.RegisterUmkmScreen
import com.eclipse.findz.screen.tutorial.TutorialScreen1
import com.eclipse.findz.screen.tutorial.TutorialScreen2
import com.eclipse.findz.screen.tutorial.TutorialScreen3
import com.eclipse.findz.screen.tutorial.TutorialScreen4
import com.eclipse.findz.screen.tutorial.TutorialScreen5

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "tutorial1") {
        composable("registerumkm") { RegisterUmkmScreen(navController = navController)}
        composable("registerinfluencer") { RegisterInfluencerScreen(navController = navController)}
        composable("login") { LoginScreen(navController = navController)}
        composable("register") { RegisterScreen(navController = navController) }
        composable("tutorial1") { TutorialScreen1(navController = navController) }
        composable("tutorial2") { TutorialScreen2(navController = navController) }
        composable("tutorial3") { TutorialScreen3(navController = navController) }
        composable("tutorial4") { TutorialScreen4(navController = navController) }
        composable("tutorial5") { TutorialScreen5(navController = navController) }
        composable("home") { HomeScreen() }
    }
}