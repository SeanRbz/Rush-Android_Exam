package com.example.rushandroid

import android.os.Build
import android.os.StrictMode
import android.support.multidex.MultiDexApplication
import androidx.lifecycle.LifecycleObserver
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class Core: MultiDexApplication(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
    }
}