package net.updategames.gra.domain

import android.icu.util.TimeZone
import androidx.core.net.toUri
import com.onesignal.OneSignal

class AviaLinkCreation {

    fun getAviaApplsLink(p0: MutableMap<String, Any>, appsFlyerUid: String, gAdId: String): String{
        val link = "https://goldplane.today/avia.php".toUri().buildUpon().apply {
            appendQueryParameter(secure_get_parametr, secure_key)
            appendQueryParameter(gadid_key, gAdId)
            appendQueryParameter(deeplink_key, "null")
            appendQueryParameter(source_key, p0["media_source"].toString())
            appendQueryParameter(af_id_key, appsFlyerUid)
            appendQueryParameter(adset_id_key, p0["adset_id"].toString())
            appendQueryParameter(campaign_id_key, p0["campaign_id"].toString())
            appendQueryParameter(app_campaign_key, p0["campaign"].toString())
            appendQueryParameter(adset_key, p0["adset"].toString())
            appendQueryParameter(adgroup_key, p0["adgroup"].toString())
            appendQueryParameter(orig_cost_key, p0["orig_cost"].toString())
            appendQueryParameter(af_siteid_key, p0["af_siteid"].toString())
            appendQueryParameter(dev_tmz_key, TimeZone.getDefault().id)
        }.toString()

        oneSignalMethod(gAdId)

        return link
    }

    fun getAviaFBLink(fb: String, gAdId: String, appsFlyerUid: String): String{
        val link = "https://goldplane.today/avia.php".toUri().buildUpon().apply {
            appendQueryParameter(secure_get_parametr, secure_key)
            appendQueryParameter(gadid_key, gAdId)
            appendQueryParameter(deeplink_key, fb)
            appendQueryParameter(source_key, "deeplink")
            appendQueryParameter(af_id_key, appsFlyerUid)
            appendQueryParameter(adset_id_key, "null")
            appendQueryParameter(campaign_id_key, "null")
            appendQueryParameter(app_campaign_key, "null")
            appendQueryParameter(adset_key, "null")
            appendQueryParameter(adgroup_key, "null")
            appendQueryParameter(orig_cost_key, "null")
            appendQueryParameter(af_siteid_key, "null")
            appendQueryParameter(dev_tmz_key, TimeZone.getDefault().id)
        }.toString()

        oneSignalMethod(gAdId)

        return link
    }


    private fun oneSignalMethod(gAdId: String){
        OneSignal.setAppId("2e1ae866-b293-487f-8051-f2ab3b86bcc3")
        OneSignal.setExternalUserId(gAdId)
    }

    companion object{
        val secure_get_parametr = "uuNvL5GXHy"
        val secure_key = "OJYlLe7aWt"
        val dev_tmz_key = "6Jv7K4auEw"
        val gadid_key = "biJvSaqmMh"
        val deeplink_key = "o73ITDrb48"
        val source_key = "5r8e3eW59w"
        val af_id_key = "Fo1XfA9IzK"
        val adset_id_key = "j1yUbQyL7y"
        val campaign_id_key = "INUXD4S5ca"
        val app_campaign_key = "wfapPzBIYF"
        val adset_key = "zzjtjmeE4i"
        val adgroup_key = "sdnpt1O6Ty"
        val orig_cost_key = "E4BBSUFaPN"
        val af_siteid_key = "uyvGsl9P6S"
    }
}