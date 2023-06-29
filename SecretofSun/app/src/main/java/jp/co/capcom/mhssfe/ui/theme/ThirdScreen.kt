package jp.co.capcom.mhssfe.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.co.capcom.mhssfe.R
import jp.co.capcom.mhssfe.SecretConstants
import kotlinx.coroutines.delay
import java.util.Calendar
import kotlin.math.roundToInt


@Composable
fun ThirdScreen(){

    val matrix = ColorMatrix()
    matrix.setToSaturation(0F)

    val isLose = remember {
        mutableStateOf(false)
    }


    val offsetX1 = remember { mutableFloatStateOf(0f) }
    val offsetY1 = remember { mutableFloatStateOf(150f) }

    val offsetX2 = remember { mutableFloatStateOf(0f) }
    val offsetY2 = remember { mutableFloatStateOf(150f) }

    val offsetX3 = remember { mutableFloatStateOf(0f) }
    val offsetY3 = remember { mutableFloatStateOf(150f) }

    val offsetX4 = remember { mutableFloatStateOf(0f) }
    val offsetY4 = remember { mutableFloatStateOf(300f) }

    val offsetX5 = remember { mutableFloatStateOf(0f) }
    val offsetY5 = remember { mutableFloatStateOf(300f) }

    val offsetX6 = remember { mutableFloatStateOf(0f) }
    val offsetY6 = remember { mutableFloatStateOf(300f) }

    //Timer
    val time = 10
    var timer by remember { mutableIntStateOf(time) }
    LaunchedEffect(key1 = timer) {
        if (timer > 0) {
            delay(1000L)
            timer -= 1
        } else {
            isLose.value = true
        }
    }




    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = SecretConstants.BACKGROUND,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Hurry Up $timer",
            color = Color.White,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 64.dp)
        )

        if(isLose.value){
            Text(
                text = "You Lose (",
                color = Color.Yellow,
                fontSize = 56.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        Row(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 48.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ){
            Image(
                painter = painterResource(id = R.drawable.element_1_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .size(72.dp),
                colorFilter = ColorFilter.colorMatrix(matrix)
            )

            Image(
                painter = painterResource(id = R.drawable.element_2_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .size(72.dp),
                colorFilter = ColorFilter.colorMatrix(matrix)

            )

            Image(
                painter = painterResource(id = R.drawable.element_3_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .size(72.dp),
                colorFilter = ColorFilter.colorMatrix(matrix)

            )

            Image(
                painter = painterResource(id = R.drawable.element_4_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .size(72.dp),
                colorFilter = ColorFilter.colorMatrix(matrix)

            )

        }


        Box(modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.element_1_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(48.dp)
                    .onGloballyPositioned {
                        Log.d("123123", "onGloballyPositioned ${it.positionInRoot()}")
                    }
                    .offset { IntOffset(offsetX1.value.roundToInt(), offsetY1.value.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX1.value += dragAmount.x
                            offsetY1.value += dragAmount.y
                        }
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.element_2_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(48.dp)
                    .onGloballyPositioned {
                        Log.d("123123", "onGloballyPositioned ${it.positionInRoot()}")
                    }
                    .offset { IntOffset(offsetX2.value.roundToInt(), offsetY2.value.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX2.value += dragAmount.x
                            offsetY2.value += dragAmount.y
                        }
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.element_3_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(48.dp)
                    .onGloballyPositioned {
                        Log.d("123123", "onGloballyPositioned ${it.positionInRoot()}")
                    }
                    .offset { IntOffset(offsetX3.value.roundToInt(), offsetY3.value.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX3.value += dragAmount.x
                            offsetY3.value += dragAmount.y
                        }
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.element_4_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .size(48.dp)
                    .onGloballyPositioned {
                        Log.d("123123", "onGloballyPositioned ${it.positionInRoot()}")
                    }
                    .offset { IntOffset(offsetX4.value.roundToInt(), offsetY4.value.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX4.value += dragAmount.x
                            offsetY4.value += dragAmount.y
                        }
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.element_5_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(48.dp)
                    .onGloballyPositioned {
                        Log.d("123123", "onGloballyPositioned ${it.positionInRoot()}")
                    }
                    .offset { IntOffset(offsetX5.value.roundToInt(), offsetY5.value.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX5.value += dragAmount.x
                            offsetY5.value += dragAmount.y
                        }
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.element_6_936),
                contentDescription = SecretConstants.BACKGROUND,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(48.dp)
                    .onGloballyPositioned {
                        Log.d("123123", "onGloballyPositioned ${it.positionInRoot()}")
                    }
                    .offset { IntOffset(offsetX6.value.roundToInt(), offsetY6.value.roundToInt()) }
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX6.value += dragAmount.x
                            offsetY6.value += dragAmount.y
                        }
                    }
            )
        }
    }
}


@Composable
@Preview
fun ThirdPrev(){
    ThirdScreen()
}