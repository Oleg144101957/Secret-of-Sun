package jp.co.capcom.mhssfe.data

import android.content.Context
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import jp.co.capcom.mhssfe.domain.Getter1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Get1 : Getter1{
    override suspend fun execute(context: Context): String = withContext(Dispatchers.IO){
        AdvertisingIdClient.getAdvertisingIdInfo(context).id.toString()
    }
}