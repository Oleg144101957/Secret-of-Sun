package jp.co.capcom.mhssfe.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.co.capcom.mhssfe.R
import jp.co.capcom.mhssfe.SecretConstants


@Composable
fun FifthScreen() {


    val checkedState1 = remember{
        mutableStateOf(true)
    }

    val checkedState2 = remember{
        mutableStateOf(true)
    }

    val checkedState3 = remember{
        mutableStateOf(true)
    }

    val checkedState4 = remember{
        mutableStateOf(true)
    }


    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = SecretConstants.BACKGROUND,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 72.dp)
            .fillMaxWidth()) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedState1.value,
                    onCheckedChange = { checkedState1.value = it }
                )

                Text(
                    text = stringResource(id = R.string.app_settings1),
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedState2.value,
                    onCheckedChange = { checkedState2.value = it }
                )

                Text(
                    text = stringResource(id = R.string.app_settings2),
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedState3.value,
                    onCheckedChange = { checkedState3.value = it }
                )

                Text(
                    text = stringResource(id = R.string.app_settings3),
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkedState4.value,
                    onCheckedChange = { checkedState4.value = it }
                )

                Text(
                    text = stringResource(id = R.string.app_settings4),
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Composable
@Preview
fun FifthPrev(){
    FifthScreen()
}