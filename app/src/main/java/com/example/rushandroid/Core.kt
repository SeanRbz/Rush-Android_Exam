package com.example.rushandroid

import android.support.multidex.MultiDexApplication
import androidx.lifecycle.LifecycleObserver
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class Core: MultiDexApplication(), LifecycleObserver {
}