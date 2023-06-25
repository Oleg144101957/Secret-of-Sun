package jp.co.capcom.mhssfe.data

import android.content.Context
import com.facebook.applinks.AppLinkData
import jp.co.capcom.mhssfe.domain.Getter2
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Get2 : Getter2 {
    override suspend fun execute(context: Context): String = suspendCoroutine { continuation ->
        AppLinkData.fetchDeferredAppLinkData(context){
            continuation.resume(it?.targetUri.toString())
        }
    }
}