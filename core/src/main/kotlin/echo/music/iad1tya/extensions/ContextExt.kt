package echo.music.iad1tya.extensions

import android.content.Context
import com.music.innertube.utils.parseCookieString
import echo.music.iad1tya.constants.InnerTubeCookieKey
import echo.music.iad1tya.constants.YtmSyncKey
import echo.music.iad1tya.utils.dataStore
import echo.music.iad1tya.utils.get
import kotlinx.coroutines.runBlocking

fun Context.isSyncEnabled(): Boolean {
  return runBlocking { dataStore.get(YtmSyncKey, true) && isUserLoggedIn() }
}

fun Context.isUserLoggedIn(): Boolean {
  return runBlocking {
    val cookie = dataStore[InnerTubeCookieKey] ?: ""
    "SAPISID" in parseCookieString(cookie) && isInternetConnected()
  }
}

fun Context.isInternetConnected(): Boolean = true
