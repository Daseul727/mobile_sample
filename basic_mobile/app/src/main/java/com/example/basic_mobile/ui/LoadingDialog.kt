package com.example.basic_mobile.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.TextView
import com.example.basic_mobile.R

class LoadingDialog {

    companion object {
        var wheelDialog: Dialog? = null

        fun showLoadingDialog(context: Context, strMsg: String = ""): Dialog? {
            wheelDialog = Dialog(context)

            val inflate = LayoutInflater.from(context)
                .inflate(R.layout.widget_textprogressbar, null)

            val msg = inflate.findViewById<TextView>(R.id.tv_message)
            msg.text = strMsg
            wheelDialog?.setContentView(inflate)
            wheelDialog?.setCancelable(false)
            wheelDialog?.window!!.setBackgroundDrawable(
                ColorDrawable(Color.TRANSPARENT)
            )
            wheelDialog?.show()

            return wheelDialog
        }

        fun hideLoading() {
            if (wheelDialog != null && wheelDialog?.isShowing!!) {
                wheelDialog?.cancel()
                wheelDialog = null
            }
        }
        fun showLoading(ctx: Context) {
            hideLoading()
            showLoadingDialog(ctx)
        }


    }
}