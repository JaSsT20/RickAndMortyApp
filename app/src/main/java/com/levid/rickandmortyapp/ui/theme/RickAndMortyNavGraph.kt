package com.levid.rickandmortyapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.levid.rickandmortyapp.ui.Screen
import com.levid.rickandmortyapp.ui.detail.DetailScreen
import com.levid.rickandmortyapp.ui.home.HomeScreen

@Composable
fun RickAndMortyNavGraph(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToDetail: (Int) -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onItemClicked = { navigateToDetail(it) }
            )
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) {
            DetailScreen(
                upPress = navigateToHome
            )
        }
    }
}