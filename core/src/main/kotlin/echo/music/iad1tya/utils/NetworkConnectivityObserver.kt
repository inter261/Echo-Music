package echo.music.iad1tya.utils

import android.content.Context
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Tidak lagi memantau atau memvalidasi jaringan.
 * Koneksi selalu dianggap tersedia.
 * Gangguan jaringan akan ditangani ketika request gagal.
 */
class NetworkConnectivityObserver(
    @Suppress("UNUSED_PARAMETER") context: Context
) {
    private val _networkStatus = Channel<Boolean>(Channel.CONFLATED)

    val networkStatus = _networkStatus.receiveAsFlow()

    init {
        _networkStatus.trySend(true)
    }

    fun unregister() {
        // Tidak ada callback yang perlu dilepas.
    }

    fun isCurrentlyConnected(): Boolean = true
}
