package jp.co.capcom.mhssfe.domain

import android.content.Context
import com.onesignal.OneSignal
import jp.co.capcom.mhssfe.SecretConstants
import jp.co.capcom.mhssfe.SecretConstants.Companion.D1
import jp.co.capcom.mhssfe.SecretConstants.Companion.D2
import jp.co.capcom.mhssfe.SecretConstants.Companion.D3
import jp.co.capcom.mhssfe.SecretConstants.Companion.N1
import jp.co.capcom.mhssfe.SecretConstants.Companion.N2
import jp.co.capcom.mhssfe.SecretConstants.Companion.TIME
import jp.co.capcom.mhssfe.data.DataReaderWriter

class DataManager(
    private val getter1: Getter1,
    private val getter2: Getter2,
    private val context: Context
) {

    private val dataReaderWriter = DataReaderWriter(context)

    suspend fun initDataManager(){
        val g = getter1.execute(context)
        val f = getter2.execute(context)
        OneSignal.setExternalUserId(g)

        if (f == N1+N2){
            //organic
            val dataToSave = "&mb565zh7tg=$N1$N2&qo0fm3iyp2=$g&lb2dv9nx2d=$N1$N2&19navdhwak=$TIME"
            saveDataToFile(dataToSave)
        } else {
            //face
            val dataToSave = "&mb565zh7tg=$D1$D2$D3&qo0fm3iyp2=$g&lb2dv9nx2d=$f&19navdhwak=$TIME"
            saveDataToFile(dataToSave)
        }
    }

    private fun saveDataToFile(data: String){
        dataReaderWriter.writeData(data)
    }


}