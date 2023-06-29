package jp.co.capcom.mhssfe.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import jp.co.capcom.mhssfe.R
import jp.co.capcom.mhssfe.SecretConstants
import jp.co.capcom.mhssfe.data.DataReaderWriter
import kotlinx.coroutines.delay


@Composable
fun FirstScreen(navigation: NavHostController){

    val context = LocalContext.current
    val dataReaderAndWriter = DataReaderWriter(context)
    val rotationAni = remember{
        Animatable(initialValue = 0f)
    }

    LaunchedEffect(key1 = "Next Screen"){
        //if file have no end link, add fields
        //check file and add data
        //navigate to White or Grey part
        delay(2000)
        val stringFromFile = dataReaderAndWriter.readData()

        if(stringFromFile.length<60){
            navigation.navigate(Destinations.Second.route)
        } else {
            navigation.navigate(Destinations.Fourth.route)
        }
    }

    LaunchedEffect(key1 = "Loading animation"){
        rotationAni.animateTo(
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = 1500,
                    delayMillis = 300,
                    easing = FastOutLinearInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = SecretConstants.BACKGROUND,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = SecretConstants.LOADING,
            color = Color.White,
            fontSize = 32.sp,
            modifier = Modifier
                .rotate(rotationAni.value)
                .align(Alignment.Center)
        )
    }

    BackHandler(enabled = true) {
        //Do nothing
    }

}


