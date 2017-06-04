package com.noj.eval

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.noj.eval.data.DaggerEvalRepositoryComponent
import com.noj.eval.data.EvalRepositoryComponent
import io.fabric.sdk.android.Fabric


class EvalApplication : Application() {

    lateinit var evalRepositoryComponent: EvalRepositoryComponent

    override fun onCreate() {
        super.onCreate()
        val fabric = Fabric.Builder(this)
                .kits(Crashlytics())
                .debuggable(true)
                .build()
        Fabric.with(fabric)
        evalRepositoryComponent = DaggerEvalRepositoryComponent.builder()
                .applicationModule(ApplicationModule((this.applicationContext)))
                .build();
    }

}