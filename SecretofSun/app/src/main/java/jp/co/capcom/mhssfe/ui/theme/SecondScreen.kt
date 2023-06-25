package jp.co.capcom.mhssfe.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay


@Composable
fun SecondScreen(navigation: NavHostController) {

    LaunchedEffect(key1 = "Next Screen"){
        delay(2000)
        navigation.navigate(Destinations.Fourth.route)

    }

    Text(text = "Second Screen (Game chooser)", fontSize = 32.sp)
}