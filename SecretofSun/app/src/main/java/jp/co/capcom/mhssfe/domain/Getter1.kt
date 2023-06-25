package jp.co.capcom.mhssfe.domain

import android.content.Context

interface Getter1 {
    suspend fun execute(context: Context): String
}