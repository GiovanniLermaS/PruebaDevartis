package com.example.pruebadevartis.util

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.pruebadevartis.R

const val BASE_URL_RETROFIT = "http://167.99.162.146/"
const val LOGIN = "users/login"
const val REGISTER = "users/register"

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

