package org.asiafoundation.lets.ui.theme

import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import org.asiafoundation.lets.R

@Composable
fun Scene2(navigation: NavHostController) {

    val context = LocalContext.current as ComponentActivity


    val animateYoffset = remember {
        Animatable(-400f)
    }

    LaunchedEffect(Unit){
        animateYoffset.animateTo(
            targetValue = -128f,
            animationSpec = tween(
                durationMillis = 800,
                delayMillis = 300,
                easing = FastOutSlowInEasing
            )
        )
    }

    
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.mainbackground),
            contentDescription = "start background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        
        Image(
            painter = painterResource(id = R.drawable.element5element),
            contentDescription = "gnom",
            modifier = Modifier
                .align(Alignment.BottomStart)
        )

        Image(
            painter = painterResource(id = R.drawable.element6element),
            contentDescription = "gnom",
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )

        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .offset(y = animateYoffset.value.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.element8element),
                contentDescription = "play",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navigation.navigate(Displays.DisplayThree.scene)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.element9element),
                contentDescription = "play",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        navigation.navigate(Displays.DisplayFour.scene)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.element10element),
                contentDescription = "play",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        context.finish()
                    }
            )
        }
    }

    BackHandler(enabled = true) {
        //off
    }
}

@Composable
@Preview
fun Prev2(){
    val nav = rememberNavController()
    Scene2(navigation = nav)
}