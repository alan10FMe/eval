package com.noj.eval.data

import android.content.Context
import com.noj.eval.data.local.LocalData
import com.noj.eval.data.local.LocalDataSource
import com.noj.eval.data.remote.RemoteData
import com.noj.eval.data.remote.RemoteDataSource
import com.noj.eval.data.sharedpreferences.SharedPreferencesData
import com.noj.eval.data.sharedpreferences.SharedPreferencesDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EvalRepositoryModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(context: Context): LocalData {
        return LocalDataSource(context)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(): RemoteData {
        return RemoteDataSource()
    }

    @Singleton
    @Provides
    fun provideSharedPreference(context: Context): SharedPreferencesData {
        return SharedPreferencesDataSource(context)
    }

}