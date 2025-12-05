package com.example.questroom.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.questroom.view.DetailSiswaScreen
import com.example.questroom.view.EditSiswaScreen
import com.example.questroom.view.EntrySiswaScreen
import com.example.questroom.view.HomeScreen
import com.example.questroom.view.route.DestinasiDetailSiswa
import com.example.questroom.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.questroom.view.route.DestinasiEntry
import com.example.questroom.view.route.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(),
             modifier: Modifier) {
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = Modifier)
    {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { navController.navigate("${DestinasiDetailSiswa.route}/${it}") }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }
        //Edit
        composable(
            DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg) {
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateBack = { navController.navigateUp() },
                onNavigateAfterDelete = {
                    navController.popBackStack(DestinasiHome.route, inclusive = false)
                }
            )
        }
        composable(DestinaasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg) {
                type = NavType.IntType
            })
        ){
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }


    }
}