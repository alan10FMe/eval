package com.noj.eval

import android.content.Context
import dagger.Module;
import dagger.Provides

@Module
class ApplicationModule(val context: Context) {

    @Provides fun provideContext() = context

}