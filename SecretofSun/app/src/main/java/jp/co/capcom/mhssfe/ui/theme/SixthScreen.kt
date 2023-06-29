package jp.co.capcom.mhssfe.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.co.capcom.mhssfe.R
import jp.co.capcom.mhssfe.SecretConstants


@Composable
fun SixthScreen(){

    val scrollState = rememberScrollState()
    
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = SecretConstants.BACKGROUND,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = stringResource(id = R.string.app_rules),
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .padding(12.dp)
                .verticalScroll(scrollState)
        )
    }
    
    
}