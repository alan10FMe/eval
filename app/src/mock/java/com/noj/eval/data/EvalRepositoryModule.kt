package com.noj.eval.data

import com.noj.eval.data.local.LocalDataSource
import com.noj.eval.data.remote.FakeRemoteDataSource
import com.noj.eval.data.sharedpreferences.SharedPreferencesDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class EvalRepositoryModule {

    @Singleton
    @Binds
    @Local
    abstract fun provideLocalDataSource(dataSource: LocalDataSource): EvalDataSource

    @Singleton
    @Binds
    @Remote
    abstract fun provideRemoteDataSource(dataSource: FakeRemoteDataSource): EvalDataSource

    @Singleton
    @Binds
    @SharedPreferences
    abstract fun provideSharedPreference(dataSource: SharedPreferencesDataSource): EvalDataSource

}