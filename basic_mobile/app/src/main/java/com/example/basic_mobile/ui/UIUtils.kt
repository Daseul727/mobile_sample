package com.example.basic_mobile.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build

/**
 * Classs: UIUtils
 * Created by seo4872 on 2023/07/24

 * Description:
 */
class UIUtils {
    companion object {
        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            if (cm != null)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    val network: Network = cm.activeNetwork ?: return false
                    val capabilities: NetworkCapabilities? =
                        cm.getNetworkCapabilities(network) ?: return false
                    return capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                            || capabilities.hasTransport(
                        NetworkCapabilities.TRANSPORT_CELLULAR
                    ))
                } else {
                    val activeNetwork = cm.activeNetworkInfo
                    return activeNetwork != null && activeNetwork.isConnectedOrConnecting
                }
            return false
        }
    }
}