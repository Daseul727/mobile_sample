package com.example.basic_mobile.common

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.basic_mobile.R
import com.example.basic_mobile.ui.LoadingDialog
import com.example.basic_mobile.ui.UIUtils
import com.google.android.material.snackbar.Snackbar

open class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun redSnackBar(message: String = getString(R.string.error_internet_connetion)) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
            .setTextColor(Color.WHITE).setBackgroundTint(Color.RED)
            .show()
    }

    fun hideLoading() {
        LoadingDialog.hideLoading()
    }

    fun showLoading() {
        if (isNetworkConnected()) {
            hideLoading()
            val dialog = LoadingDialog.showLoadingDialog(this)
        } else {
            redSnackBar()
        }
    }

    fun isNetworkConnected(): Boolean {
        return UIUtils.isNetworkConnected(applicationContext)
    }

}