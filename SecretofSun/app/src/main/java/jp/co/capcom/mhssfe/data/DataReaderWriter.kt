package jp.co.capcom.mhssfe.data

import android.content.Context
import android.util.Log
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

class DataReaderWriter(context: Context) {

    private val file = File(context.filesDir, "data.txt")

    fun readData(): String{
        val stringBuilder = StringBuilder()
        try {
            file.bufferedReader().useLines { lines ->
                lines.forEach {
                    stringBuilder.append(it)
                }
            }
        } catch (e: IOException) {
            Log.d("123123", "MainActivity somethig goes wrong in read block")

        }

        return stringBuilder.toString()
    }

    fun writeData(data: String){
        val fileWriter = FileWriter(file, true)
        val bufferedWriter = BufferedWriter(fileWriter)
        bufferedWriter.write(data)
        bufferedWriter.newLine()
        bufferedWriter.close()
        fileWriter.close()
    }


}