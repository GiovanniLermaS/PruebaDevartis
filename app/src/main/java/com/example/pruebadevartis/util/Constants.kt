package com.example.pruebadevartis.util

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.pruebadevartis.R

const val BASE_URL_RETROFIT = "https://167.99.162.146/"
const val REGISTER = "users/register"
const val EVENTS_LAST = "eventslast.php"
const val LEAGUE = "l"
const val TEAM = "team"
const val ID = "id"

const val PACKAGE_TWITTER = "com.twitter.android"
const val PACKAGE_INSTAGRAM = "com.instagram.android"
const val PACKAGE_YOUTUBE = "com.google.android.youtube"

var dialog: Dialog? = null

fun hasNetwork(context: Context): Boolean? {
    var isConnected: Boolean? = false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}

fun showProgress(context: Context, isAlertInit: Boolean) {
    if (isAlertInit) {
        val builder = AlertDialog.Builder(context)
        builder.setView(R.layout.progress)
        builder.setCancelable(false)
        dialog = builder.create()
    }
    if (isAlertInit) {
        try {
            dialog?.show()
        } catch (e: Exception) {
            showProgress(context, isAlertInit = true)
        }
    } else dialog?.dismiss()
}

