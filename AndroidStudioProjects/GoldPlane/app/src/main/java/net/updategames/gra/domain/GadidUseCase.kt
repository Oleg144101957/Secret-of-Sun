package net.updategames.gra.domain

import android.content.Context
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GadidUseCase(private val context: Context) {

    suspend fun getGadId() : String = withContext(Dispatchers.IO){
        AdvertisingIdClient.getAdvertisingIdInfo(context).id.toString().also {
            OneSignal.setExternalUserId(it)
        }
    }

}