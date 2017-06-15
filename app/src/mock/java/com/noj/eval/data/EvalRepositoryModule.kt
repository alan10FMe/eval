package com.noj.eval.data

import com.noj.eval.data.local.LocalData
import com.noj.eval.data.local.LocalDataSource
import com.noj.eval.data.remote.FakeRemoteDataSource
import com.noj.eval.data.remote.RemoteData
import com.noj.eval.data.sharedpreferences.SharedPreferencesData
import com.noj.eval.data.sharedpreferences.SharedPreferencesDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class EvalRepositoryModule {

    @Singleton
    @Binds
    abstract fun provideLocalDataSource(dataSource: LocalDataSource): LocalData

    @Singleton
    @Binds
    abstract fun provideRemoteDataSource(dataSource: FakeRemoteDataSource): RemoteData

    @Singleton
    @Binds
    abstract fun provideSharedPreference(dataSource: SharedPreferencesDataSource): SharedPreferencesData

}