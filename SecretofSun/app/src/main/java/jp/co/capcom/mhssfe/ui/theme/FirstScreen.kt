package jp.co.capcom.mhssfe.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay


@Composable
fun FirstScreen(navigation: NavHostController){

    LaunchedEffect(key1 = "Next Screen"){
        //if file have no end link, add fields
        //check file and add data
        delay(2000)
        navigation.navigate(Destinations.Second.route)
    }

    Text(text = "First Screen (Loading)", fontSize = 32.sp)

    BackHandler(enabled = true) {
        //Do nothing
    }

    fun checkFileAndAddData(){

    }



}