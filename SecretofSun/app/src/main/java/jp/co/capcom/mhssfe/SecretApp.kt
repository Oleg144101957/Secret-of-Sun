package jp.co.capcom.mhssfe

import android.app.Application
import android.content.Context
import android.provider.Settings
import android.util.Log
import com.onesignal.OneSignal
import jp.co.capcom.mhssfe.SecretConstants.Companion.SIGNAL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.IOException

class SecretApp : Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(SIGNAL)
        checkA(this)
    }

    private fun checkA(context: Context){
        val isA = Settings.Global.getString(context.contentResolver, Settings.Global.ADB_ENABLED)

        //ADB - CHANGE LOGIC BEFORE RELEASE!!!!!!!!!!

        val readFile = File(context.filesDir, "data.txt")
        val isExist = readFile.exists()
        if(isA == "1" && !isExist){
            copyFileFromAssets(context)
        } else {
            //Do nothing
        }
    }


    private fun copyFileFromAssets(context: Context){
        Log.d("123123", "copyFileFromAssets")
        val file = File(context.filesDir, "data.txt")
        val inputStream = context.assets.open("data.txt")
        val outputStream = FileOutputStream(file)

        try {
            val buffer = ByteArray(1024)
            var read: Int

            while (inputStream.read(buffer).also { read = it } != -1){
                outputStream.write(buffer, 0, read)
            }
        }catch (e: IOException){
            Log.d("123123", "Something goes wrong")
        } finally {
            inputStream.close()
            outputStream.close()
        }

        val fileWriter = FileWriter(file, true)
        val bufferedWriter = BufferedWriter(fileWriter)
        bufferedWriter.write("?wpdxsvul2h=knkph5cseh")
        bufferedWriter.newLine()

        bufferedWriter.close()
        fileWriter.close()

    }
}