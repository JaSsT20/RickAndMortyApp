package com.levid.rickandmortyapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.levid.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.levid.rickandmortyapp.ui.theme.RickAndMortyNavGraph

@Composable
fun RickAndMortyApp() {
    RickAndMortyAppTheme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            RickAndMortyActions(navController)
        }

        RickAndMortyNavGraph(
            navController = navController,
            navigateToHome = navigationActions.navigateToHome,
            navigateToDetail = navigationActions.navigateToDetail
        )
    }
}