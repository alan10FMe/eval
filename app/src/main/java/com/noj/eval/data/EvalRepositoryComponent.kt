package com.noj.eval.data

import com.noj.eval.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(EvalRepositoryModule::class, ApplicationModule::class))
interface EvalRepositoryComponent {

    val evalRepository: EvalRepository

}
