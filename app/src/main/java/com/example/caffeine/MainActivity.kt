package com.example.caffeine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.caffeine.screens.chooseCoffee.ChooseCoffeeScreen
import com.example.caffeine.screens.chooseSnack.ChooseSnackScreen
import com.example.caffeine.screens.finalOrder.FinalOrderScreen
import com.example.caffeine.screens.home.HomeScreen
import com.example.caffeine.screens.pager.PagerScreen
import com.example.caffeine.screens.prepareCoffee.PrepareCoffeeScreen
import com.example.caffeine.ui.theme.CaffeineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaffeineTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()  //remember where i'm
                         NavHost(navController = navController, startDestination ="homeScreen"){ //contains composable will show
                             composable("homeScreen"){ HomeScreen(navController = navController) }

                             composable("pagerScreen"){ PagerScreen(navController = navController) }

                             composable("chooseCoffeeScreen/{coffeeName}", arguments = listOf(
                                 navArgument("coffeeName"){ type=NavType.StringType}
                             )) { backStackEntry ->
                                 val coffeeName = backStackEntry.arguments?.getString("coffeeName") ?: "Macchiato"

                                 ChooseCoffeeScreen(navController = navController,coffeeName = coffeeName)
                             }

                             composable("prepareCoffeeScreen/{coffeeCupSize}", arguments = listOf(
                                 navArgument("coffeeCupSize"){type= NavType.IntType}
                             )){ backStackEntry ->
                                 val coffeeCupSize = backStackEntry.arguments?.getInt("coffeeCupSize") ?: 200

                                 PrepareCoffeeScreen(
                                 navController = navController,
                                 coffeeCupSize = coffeeCupSize
                             ) }

                             composable("chooseSnackScreen"){ ChooseSnackScreen(navController = navController) }

                             composable ("finalOrder/{index}", arguments = listOf(
                                 navArgument("index"){type = NavType.IntType}
                             )) { backStackEntry ->
                                 val indexOfImage = backStackEntry.arguments?.getInt("index")?:0
                                 FinalOrderScreen(navController = navController, imageIndex = indexOfImage)
                             }
                         }
                }
            }
        }
    }
}