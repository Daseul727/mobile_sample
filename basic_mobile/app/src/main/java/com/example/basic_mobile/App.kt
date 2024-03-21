package com.example.basic_mobile

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.BuildConfig
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){
    private val TAG = "TLOG"

    companion object {
        private lateinit var mContext: Context

        @JvmStatic
        fun getContext(): Context {
            return mContext.applicationContext
        }
    }

    init {
        mContext = this
    }

    override fun onCreate() {
        super.onCreate()
        initLogger(TAG)
        initNotification()
    }

    private fun initLogger(tag: String) {
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()

            .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
            .methodCount(0)         // (Optional) How many method line to show. Default 2
            .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
            .tag(tag)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build();
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

    private fun initNotification() {

    }
}