package jp.co.capcom.mhssfe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import jp.co.capcom.mhssfe.SecretConstants.Companion.STATIC_DATA
import jp.co.capcom.mhssfe.data.DataReaderWriter
import jp.co.capcom.mhssfe.data.Get1
import jp.co.capcom.mhssfe.data.Get2
import jp.co.capcom.mhssfe.domain.DataManager
import jp.co.capcom.mhssfe.ui.theme.MainNav
import jp.co.capcom.mhssfe.ui.theme.SecretOfSunTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File
import java.io.IOException

class MainActivity : ComponentActivity() {

    private lateinit var dataManager : DataManager
    private lateinit var dataReaderWriter: DataReaderWriter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureWindow()

        dataManager = DataManager(Get1(), Get2(), this)
        dataReaderWriter = DataReaderWriter(this)
        addStaticData()

        setContent {
            SecretOfSunTheme {
                MainNav()
            }
        }
    }

    private fun configureWindow() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    private fun addStaticData(){
        val context = this
        lifecycleScope.launch (Dispatchers.IO){
            val file = File(context.filesDir, "data.txt")

            if (file.exists()){
                val stringFromFile = dataReaderWriter.readData()

                if (stringFromFile.length<90){
                    //add static data
                    dataReaderWriter.writeData(STATIC_DATA)
                    dataManager.initDataManager()
                }
            }
        }
    }
}