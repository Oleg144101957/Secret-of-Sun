package jp.co.capcom.mhssfe

import android.os.Bundle
import android.util.Log
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

        dataManager = DataManager(Get1(), Get2(), this)
        dataReaderWriter = DataReaderWriter(this)

        addStaticData()

        setContent {
            SecretOfSunTheme {
                MainNav()
            }
        }
    }



    private fun addStaticData(){
        lifecycleScope.launch (Dispatchers.IO){
            val stringFromFile = dataReaderWriter.readData()

            if (stringFromFile.length<60){
                //add static data
                dataReaderWriter.writeData(STATIC_DATA)
                dataManager.initDataManager()
            }
        }
    }
}