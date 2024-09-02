package com.loc.movie_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.loc.movie_app.presentation.movie_detail.views.MovieDetailScreen
import com.loc.movie_app.presentation.movies.views.MovieScreen
import com.loc.movie_app.presentation.ui.Screen
import com.loc.movie_app.presentation.ui.theme.Movie_AppTheme
import com.loc.movie_app.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Movie_AppTheme {
                val navController= rememberNavController()
                NavHost(navController = navController,startDestination = Screen.MovieScreen.route){
                    composable(route = Screen.MovieScreen.route){

                        MovieScreen(navController = navController)
                    }
                    composable(route = Screen.MovieDetailScreen.route+"/{${IMDB_ID}}") {
                        MovieDetailScreen()
                    }

                }

            }
        }
    }
}

