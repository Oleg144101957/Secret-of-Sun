package jp.co.capcom.mhssfe.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun MainNav() {

    val navigation = rememberNavController()

    NavHost(navController = navigation, startDestination = Destinations.First.route){
        composable(route = Destinations.First.route){
            FirstScreen(navigation)
        }

        composable(route = Destinations.Second.route){
            SecondScreen(navigation)
        }

        composable(route = Destinations.Third.route){
            ThirdScreen()
        }

        composable(route = Destinations.Fourth.route){
            FourthScreen(navigation)
        }

        composable(route = Destinations.Fifth.route){
            FifthScreen()
        }

        composable(route = Destinations.Sixth.route){
            SixthScreen()
        }
    }
}