package jp.co.capcom.mhssfe.ui.theme

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import android.webkit.ValueCallback
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import jp.co.capcom.mhssfe.data.DataReaderWriter

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun FourthScreen(navigation: NavHostController){

    val context = LocalContext.current
    val dataReaderWriter = DataReaderWriter(context)

    Log.d("123123", "The current data is ${dataReaderWriter.readData()}")

    val state = rememberWebViewState(dataReaderWriter.readData())

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
                //India -> Go to second screen
            }

            override fun onPageFinished(view: WebView, url: String?) {
                super.onPageFinished(view, url)
                Log.d("123123", "The url is $url")
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
                userAgentString = it.settings.userAgentString.replace("wv", "")
            }
        }
    )

    BackHandler(enabled = true) {
        //Do nothing
    }
}

