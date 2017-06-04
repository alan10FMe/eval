package com.noj.eval.data

import android.content.Context
import com.noj.eval.data.local.LocalDataSource
import com.noj.eval.data.remote.RemoteDataSource
import com.noj.eval.data.sharedpreferences.SharedPreferencesDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EvalRepositoryModule {

    @Singleton
    @Provides
    @Local
    fun provideLocalDataSource(context: Context): EvalDataSource {
        return LocalDataSource(context)
    }

    @Singleton
    @Provides
    @Remote
    fun provideRemoteDataSource(): EvalDataSource {
        return RemoteDataSource()
    }

    @Singleton
    @Provides
    @SharedPreferences
    fun provideSharedPreference(context: Context): EvalDataSource {
        return SharedPreferencesDataSource(context)
    }

}