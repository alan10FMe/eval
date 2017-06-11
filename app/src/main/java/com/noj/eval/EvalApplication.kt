package com.noj.eval

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.noj.eval.data.DaggerEvalRepositoryComponent
import com.noj.eval.data.EvalRepositoryComponent
import io.fabric.sdk.android.Fabric

class EvalApplication : Application() {

    lateinit var evalRepositoryComponent: EvalRepositoryComponent

    override fun onCreate() {
        super.onCreate()
        val crashlytics = Crashlytics.Builder()
                .core(CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
                .build()
        Fabric.with(this, crashlytics)
        evalRepositoryComponent = DaggerEvalRepositoryComponent.builder()
                .applicationModule(ApplicationModule((this.applicationContext)))
                .build()
    }

}
