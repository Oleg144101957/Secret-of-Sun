package jp.co.capcom.mhssfe.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import jp.co.capcom.mhssfe.R
import jp.co.capcom.mhssfe.SecretConstants
import kotlinx.coroutines.delay


@Composable
fun SecondScreen(navigation: NavHostController) {

    LaunchedEffect(key1 = "Next Screen"){
        delay(2000)
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = SecretConstants.BACKGROUND,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 72.dp)
            .align(Alignment.BottomCenter)) {

            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.im_back),
                    contentDescription = SecretConstants.BACKGROUND,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            navigation.navigate(Destinations.Third.route)
                        }
                )

                Text(
                    text = SecretConstants.BTN_PLAY,
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )

            }

            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.im_back),
                    contentDescription = SecretConstants.BACKGROUND,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            navigation.navigate(Destinations.Fifth.route)
                        }
                )

                Text(
                    text = SecretConstants.BTN_SETTINGS,
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.im_back),
                    contentDescription = SecretConstants.BACKGROUND,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clickable {
                            navigation.navigate(Destinations.Sixth.route)
                        }
                )

                Text(
                    text = SecretConstants.BTN_RULES,
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }

    BackHandler() {
        //Do noth
    }

}
